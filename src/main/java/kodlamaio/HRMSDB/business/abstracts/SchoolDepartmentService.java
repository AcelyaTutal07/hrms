package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.SchoolDepartment;

public interface SchoolDepartmentService {
	DataResult<List<SchoolDepartment>> getAll();
	Result add(SchoolDepartment schoolDepartment);

}
