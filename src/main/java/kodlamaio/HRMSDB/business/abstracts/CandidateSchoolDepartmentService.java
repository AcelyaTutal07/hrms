package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.CandidateSchoolDepartment;

public interface CandidateSchoolDepartmentService {
	DataResult<List<CandidateSchoolDepartment>> getAll();
	DataResult<List<CandidateSchoolDepartment>> getByCandidate_idOrderByDateOfGraduationDesc(int candidateId);
    Result add(CandidateSchoolDepartment candidateSchoolDepartment);
	
	
}
