package kodlamaio.HRMSDB.business.concretes.auth;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.ActivationCodeService;
import kodlamaio.HRMSDB.business.abstracts.EmployerService;
import kodlamaio.HRMSDB.business.abstracts.auth.EmployerAuthService;
import kodlamaio.HRMSDB.business.validationRules.AuthValidatorService;
import kodlamaio.HRMSDB.core.utilities.business.BusinessEngine;
import kodlamaio.HRMSDB.core.utilities.email.EmailSendrService;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.verificationCode.CodeGenerator;
import kodlamaio.HRMSDB.entites.concretes.ActivationCode;
import kodlamaio.HRMSDB.entites.concretes.Employer;
import kodlamaio.HRMSDB.entites.dtos.RegisterForEmployerDto;


@Service
public class EmployerAuthManager implements EmployerAuthService {


	private final AuthValidatorService authValidatorService;
	private final EmployerService employerService;
	private final ActivationCodeService activationCodeService;
	private final EmailSendrService emailSendrService;
	
	
	@Override
	public Result register(RegisterForEmployerDto registerForEmployerDto) {
		Result result = BusinessEngine.run(authValidatorService.authNullCheck(registerForEmployerDto),
				authValidatorService.confirmPassword(registerForEmployerDto));
		if(!result.isSuccess()) {
			return result;
			
		} 
		
		Employer employer = new Employer(registerForEmployerDto.getEmail(),registerForEmployerDto.getPassword(),registerForEmployerDto.getCompanyName(),registerForEmployerDto.getWebAdress(),
				registerForEmployerDto.getPhoneNumber()
				);
			Result candidateResult = employerService.add(employer);
			if(!candidateResult.isSuccess()) {
				return candidateResult;
		
		
		}
		
		//code generatorden oluşan kodu code diye oluşturduğumuz değişkene atıycak
		String code = CodeGenerator.codeGenerator();
		ActivationCode activationCode = new ActivationCode(employer.getId(),code);
		Result activationResult = activationCodeService.add(activationCode); //aktivasyon kodunu veritabanına ekledik
		if(!activationResult.isSuccess()) {
			return activationResult;
		}
		emailSendrService.send("activationCode = " + code);
		return candidateResult;
			
	}
	@Autowired
	public EmployerAuthManager(AuthValidatorService authValidatorService,EmployerService employerService,
			ActivationCodeService activationCodeService,EmailSendrService emailSendrService) {
		super();
		this.authValidatorService = authValidatorService;
		this.employerService = employerService;
		this.activationCodeService = activationCodeService;
		this.emailSendrService = emailSendrService;
	}
	
}
