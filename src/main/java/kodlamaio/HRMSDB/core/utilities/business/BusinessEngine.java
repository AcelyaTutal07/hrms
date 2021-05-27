package kodlamaio.HRMSDB.core.utilities.business;

import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;

public class BusinessEngine {

	public static Result run(Result...  logics) {
		for(Result logic: logics) {
			if(!logic.isSuccess()) {
				return logic;
			}
		}
		return new SuccessResult();
	}
}
