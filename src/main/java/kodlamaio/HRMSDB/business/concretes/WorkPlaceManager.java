package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.WorkplaceService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.WorkplaceDao;
import kodlamaio.HRMSDB.entites.concretes.Workplace;

@Service
public class WorkPlaceManager implements WorkplaceService {

	private WorkplaceDao workplaceDao;
	
	@Autowired
	public WorkPlaceManager(WorkplaceDao workplaceDao) {
		
		this.workplaceDao = workplaceDao;
	}

	@Override
	public DataResult<List<Workplace>> getAll() {
		List<Workplace> result = this.workplaceDao.findAll();
		return new SuccessDataResult<List<Workplace>>(result);
		
	}

	@Override
	public Result add(Workplace workplace) {
		this.workplaceDao.save(workplace);
		return new SuccessResult();

	}
}
