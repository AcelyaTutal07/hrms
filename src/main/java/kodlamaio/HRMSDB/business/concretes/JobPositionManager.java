package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.JobPositionService;
import kodlamaio.HRMSDB.business.constraints.Messages;
import kodlamaio.HRMSDB.core.utilities.business.BusinessEngine;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.ErrorResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.JobPositionDao;
import kodlamaio.HRMSDB.entites.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao  jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),Messages.JobPositionListed);
        
    }
        public Result add(JobPosition JobPosition) {
        	Result result = BusinessEngine.run(isJobPositionExist(JobPosition));
        	if(result.isSuccess())
        	this.jobPositionDao.save(JobPosition);
        	return new SuccessResult(Messages.JobPositionAdded);
        }
        	
        	private Result isJobPositionExist(JobPosition jobPosition){
                if(jobPositionDao.findByTitle(jobPosition.getTitle()).isPresent()){
                    return new ErrorResult(Messages.JobTitleExist);
                }
                return new SuccessResult();
            }
}
    
   
