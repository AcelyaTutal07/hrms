package kodlamaio.HRMSDB.business.abstracts;

import java.util.Optional;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.ActivationCode;

public interface ActivationCodeService {

	Result add(ActivationCode activationCode);
	Result update(ActivationCode activationCode);
	DataResult<Optional<ActivationCode>> getByUserId(int userId);
	
	
}
