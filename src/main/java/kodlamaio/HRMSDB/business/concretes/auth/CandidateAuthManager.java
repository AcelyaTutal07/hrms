package kodlamaio.HRMSDB.business.concretes.auth;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.ActivationCodeService;
import kodlamaio.HRMSDB.business.abstracts.CandidateService;
import kodlamaio.HRMSDB.business.abstracts.auth.CandidateAuthService;
import kodlamaio.HRMSDB.business.validationRules.AuthValidatorService;
import kodlamaio.HRMSDB.core.utilities.business.BusinessEngine;
import kodlamaio.HRMSDB.core.utilities.email.EmailSendrService;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.verificationCode.CodeGenerator;
import kodlamaio.HRMSDB.entites.concretes.ActivationCode;
import kodlamaio.HRMSDB.entites.concretes.Candidate;
import kodlamaio.HRMSDB.entites.dtos.RegisterForCandidateDto;

@Service
public class CandidateAuthManager implements CandidateAuthService{

	private final AuthValidatorService authValidatorService;
	private final CandidateService candidateService;
	private final ActivationCodeService activationCodeService;
	private final EmailSendrService emailSendrService;
	
	
	@Override
	public Result register(RegisterForCandidateDto registerForCandidateDto) {
		Result result = BusinessEngine.run(authValidatorService.authNullCheck(registerForCandidateDto),
				authValidatorService.confirmPassword(registerForCandidateDto));
		if(!result.isSuccess()) {
			return result;
			
		} 
		
		Candidate candidate = new Candidate(registerForCandidateDto.getEmail(),registerForCandidateDto.getPassword(),registerForCandidateDto.getFirstName(),
				registerForCandidateDto.getLastName(),registerForCandidateDto.getNationalIdentity(),registerForCandidateDto.getDateOfBirth());
		Result candidateResult = candidateService.add(candidate);
		if(!candidateResult.isSuccess()) {
			return candidateResult;
		}
		
		//code generatorden oluşan kodu code diye oluşturduğumuz değişkene atıycak
		String code = CodeGenerator.codeGenerator();
		ActivationCode activationCode = new ActivationCode(candidate.getId(),code);
		Result activationResult = activationCodeService.add(activationCode); //aktivasyon kodunu veritabanına ekledik
		if(!activationResult.isSuccess()) {
			return activationResult;
		}
		emailSendrService.send("activationCode = " + code);
		return candidateResult;
			
	}
	@Autowired
	public CandidateAuthManager(AuthValidatorService authValidatorService,CandidateService candidateService,
			ActivationCodeService activationCodeService,EmailSendrService emailSendrService) {
		super();
		this.authValidatorService = authValidatorService;
		this.candidateService = candidateService;
		this.activationCodeService = activationCodeService;
		this.emailSendrService = emailSendrService;
	}
	
	

	
}
