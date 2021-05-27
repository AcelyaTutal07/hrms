package kodlamaio.HRMSDB.business.validationRules;

import org.springframework.stereotype.Component;

import kodlamaio.HRMSDB.business.constraints.Messages;
import kodlamaio.HRMSDB.core.utilities.results.ErrorResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.entites.dtos.AuthDto;

@Component
public class AuthValidator implements AuthValidatorService{

	@Override
	public Result authNullCheck(AuthDto authDto) {
		if((authDto.getConfirmPassword()==null||authDto.getConfirmPassword().isBlank())) {
			return new ErrorResult(Messages.notNull);
		}
		return new SuccessResult();
	}

	@Override
	public Result confirmPassword(AuthDto authDto) {
		if(!authDto.getConfirmPassword().equals(authDto.getPassword())) {
			return new ErrorResult(Messages.PasswordNotConfirmed);
		}
		return new SuccessResult();
	}

}
