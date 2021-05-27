package kodlamaio.HRMSDB.business.validationRules;

import kodlamaio.HRMSDB.business.constraints.Messages;
import kodlamaio.HRMSDB.core.utilities.results.ErrorResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.entites.concretes.User;


public class UserValidator {
	public Result userNullCheck(User user) {
if((user.getEmail()==(null)||user.getEmail().isBlank())||(user.getPassword()==(null)||user.getPassword().isBlank())){
            return new ErrorResult(Messages.notNull);
        }
            return new SuccessResult();


	}
}
