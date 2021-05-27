package kodlamaio.HRMSDB.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.EmployerService;
import kodlamaio.HRMSDB.business.validationRules.EmployerValidatorService;
import kodlamaio.HRMSDB.core.utilities.business.BusinessEngine;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMSDB.dataAccess.abstracts.UserDao;
import kodlamaio.HRMSDB.entites.concretes.Employer;

@Service
public class EmployerManager extends UserManager<Employer> implements EmployerService {

	private EmployerDao employerDao;
	private EmployerValidatorService employerValidatorService;
	
	@Autowired
	public EmployerManager(UserDao<Employer> userDao, EmployerValidatorService employerValidatorService) {
		super(userDao);
		this.employerDao=(EmployerDao)userDao;
		this.employerValidatorService = employerValidatorService;
		
	}
	
    @Override
	public Result add(Employer employer) {
		Result result = BusinessEngine.run(super.isEmailExist(employer.getEmail()),employerValidatorService.isEmailDomainCheck(employer));
		if(result.isSuccess()) {
			return super.add(employer);
		}
		return result;
	}


	
}
