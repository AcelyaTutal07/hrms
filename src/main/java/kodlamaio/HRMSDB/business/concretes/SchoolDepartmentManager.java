package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.SchoolDepartmentService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.SchoolDepartmentDao;
import kodlamaio.HRMSDB.entites.concretes.SchoolDepartment;

@Service
public class SchoolDepartmentManager  implements SchoolDepartmentService{

	private SchoolDepartmentDao schoolDepartmentDao;
	
	public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao) {
		
		this.schoolDepartmentDao = schoolDepartmentDao;
	}

	@Override
	public DataResult<List<SchoolDepartment>> getAll() {
		List<SchoolDepartment> result = this.schoolDepartmentDao.findAll();
		return new SuccessDataResult<List<SchoolDepartment>>(result);
		
	}

	@Override
	public Result add(SchoolDepartment schoolDepartment) {
		this.schoolDepartmentDao.save(schoolDepartment);
		return new SuccessResult();
	}

}
