package kodlamaio.HRMSDB.business.validationRules;



import org.springframework.stereotype.Component;

import kodlamaio.HRMSDB.business.constraints.Messages;
import kodlamaio.HRMSDB.core.utilities.results.ErrorResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;

import kodlamaio.HRMSDB.entites.concretes.Employer;

@Component
public class EmployerValidator extends UserValidator implements EmployerValidatorService{
	
	
	public Result employerNullCheck(Employer employer) {
        String companyName = employer.getCompanyName();
        String webAddress = employer.getWebAddress();
        String phoneNumber = employer.getPhoneNumber();

        if (super.userNullCheck(employer).isSuccess() || (companyName == null || companyName.isBlank())
                || (webAddress == null || webAddress.isBlank()) || (phoneNumber==null||phoneNumber.isBlank())) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }


    public Result isEmailDomainCheck(Employer employer){
        String email = employer.getEmail();
        String webAddress = employer.getWebAddress();

        String domain = webAddress.split("www.")[1]; //www. dan sonrasını alabilmek için arraya 1 veriyoruz
        if(domain.equals(email.split("@")[1])){ //@   dan sonrasını alabilmek için indexe 1 veriyoruz
        	
            return new SuccessResult();
        }
        System.out.println((email.split("@")[1]));
        System.out.println(domain);
        return new ErrorResult(Messages.domainNotEqual);
    }
    

}
	

