package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.JobPosition;



public interface JobPositionService {
	
	Result add(JobPosition jobPosition );
	DataResult<List<JobPosition>>  getAll();

}