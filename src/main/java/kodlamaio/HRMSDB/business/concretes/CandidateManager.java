package kodlamaio.HRMSDB.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.CandidateService;
import kodlamaio.HRMSDB.business.constraints.Messages;
import kodlamaio.HRMSDB.business.validationRules.CandidateValidatorService;
import kodlamaio.HRMSDB.core.adaptors.mernis.UserRealCheckService;
import kodlamaio.HRMSDB.core.adaptors.model.MernisPerson;
import kodlamaio.HRMSDB.core.utilities.business.BusinessEngine;
import kodlamaio.HRMSDB.core.utilities.results.ErrorResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMSDB.dataAccess.abstracts.UserDao;
import kodlamaio.HRMSDB.entites.concretes.Candidate;

@Service
public class CandidateManager extends UserManager<Candidate>implements CandidateService{

	private CandidateDao candidateDao;
	private UserRealCheckService  userRealCheckService;
	private CandidateValidatorService  candidateValidatorService;
	
	
	@Autowired
	public CandidateManager(UserDao<Candidate> userDao,UserRealCheckService userRealCheckService,CandidateValidatorService  candidateValidatorService) {
		super(userDao);
		this.candidateDao = (CandidateDao)userDao; //unboxing
		this.userRealCheckService = userRealCheckService;
		this.candidateValidatorService = candidateValidatorService;
		
	}
	
	
	@Override
    public Result add(Candidate candidate) {
       
            Result result = BusinessEngine.run(super.isEmailExist(candidate.getEmail()), isIdentityNumberExist(candidate.getNationalIdentity()),
                    isMernisVerified(candidate),candidateValidatorService.candidateNullCheck(candidate));
            if (result.isSuccess()) {
                return super.add(candidate);
            }
            return result;
        
    }
	
	
	private Result isIdentityNumberExist(String identityNumber) {
		if(candidateDao.findByNationalIdentity(identityNumber).isPresent()) {
			return new ErrorResult(Messages.nationalityIdentityExist);
		}
		return new SuccessResult();
	}
	
	private Result isMernisVerified(Candidate candidate) {
		MernisPerson mernisPerson = new MernisPerson(candidate.getFirstName(),candidate.getLastName(),candidate.getNationalIdentity(),candidate.getDateOfBirth());
		boolean result = userRealCheckService.validate(mernisPerson);
		if(result) {
			return new SuccessResult();
		}
		return new ErrorResult(Messages.PersonValid);
	}

}
