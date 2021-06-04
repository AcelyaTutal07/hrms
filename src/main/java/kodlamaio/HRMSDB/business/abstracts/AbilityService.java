package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.Ability;

public interface AbilityService {
	DataResult<List<Ability>> getAll();
	Result add(Ability ability);
	

}
