package kodlamaio.HRMSDB.business.validationRules;

import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.Employer;

public interface EmployerValidatorService {
	 Result employerNullCheck(Employer employer);
	 Result isEmailDomainCheck(Employer employer);
}
