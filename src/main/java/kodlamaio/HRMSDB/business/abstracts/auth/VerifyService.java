package kodlamaio.HRMSDB.business.abstracts.auth;

import kodlamaio.HRMSDB.core.utilities.results.Result;

public interface VerifyService {

	 Result verify(int userId, String activationCode);
}
