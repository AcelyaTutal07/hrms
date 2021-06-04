package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.DepartmentService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.DepartmentDao;
import kodlamaio.HRMSDB.entites.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {

	private DepartmentDao departmentDao;

	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	@Override
	public DataResult<List<Department>> getAll() {
		List<Department> result = this.departmentDao.findAll();
		return new SuccessDataResult<List<Department>>(result);
	}

	@Override
	public Result add(Department department) {
		this.departmentDao.save(department);
		return new SuccessResult();
	}

}
