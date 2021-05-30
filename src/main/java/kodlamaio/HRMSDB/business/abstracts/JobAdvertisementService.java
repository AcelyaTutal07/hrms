package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.JobAdvertisement;


public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);
	
	Result update(int jobAdvertisemenetId, JobAdvertisement jobAdvertisemenet);
	
	DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> findAllByIsActive();
	
    DataResult<List<JobAdvertisement>> getByLastApplicationDate();
	
    DataResult<List<JobAdvertisement>> getByisActiveAndEmployerId(int id);
    
    DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize);
	
    
    
}
