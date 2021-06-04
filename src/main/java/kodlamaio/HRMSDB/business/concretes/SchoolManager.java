package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.SchoolService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.SchoolDao;
import kodlamaio.HRMSDB.entites.concretes.School;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		List<School> result = this.schoolDao.findAll();
		return new SuccessDataResult<List<School>>(result);
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult();
	}


}
