package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.Workplace;

public interface WorkplaceService {


	DataResult<List<Workplace>> getAll();
	
	Result add(Workplace workplace);
}
