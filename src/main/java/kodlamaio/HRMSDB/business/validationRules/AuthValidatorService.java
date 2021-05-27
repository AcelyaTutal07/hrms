package kodlamaio.HRMSDB.business.validationRules;

import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.dtos.AuthDto;

public interface AuthValidatorService {
	Result authNullCheck(AuthDto authDto);
	Result confirmPassword(AuthDto authDto);
	

	
}
