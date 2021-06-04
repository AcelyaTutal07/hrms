package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.CandidateSchoolDepartmentService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.CandidateSchoolDepartmentDao;
import kodlamaio.HRMSDB.entites.concretes.CandidateSchoolDepartment;

@Service
public class CandidateSchoolDepartmentManager implements CandidateSchoolDepartmentService {

	private CandidateSchoolDepartmentDao  candidateSchoolDepartmentDao; 
	
	
	public CandidateSchoolDepartmentManager(CandidateSchoolDepartmentDao candidateSchoolDepartmentDao) {
		
		this.candidateSchoolDepartmentDao = candidateSchoolDepartmentDao;
	}
	
	@Override
	public DataResult<List<CandidateSchoolDepartment>> getAll() {
		List<CandidateSchoolDepartment> result = this.candidateSchoolDepartmentDao.findAll();
		return new SuccessDataResult<List<CandidateSchoolDepartment>>(result);
	}


	@Override
	public DataResult<List<CandidateSchoolDepartment>> getByCandidate_idOrderByDateOfGraduationDesc(int candidateId) {
		List<CandidateSchoolDepartment> result = this.candidateSchoolDepartmentDao.getByCandidate_idOrderByDateOfGraduationDesc(candidateId);
		return new SuccessDataResult<List<CandidateSchoolDepartment>>(result);
	}

	@Override
	public Result add(CandidateSchoolDepartment candidateSchoolDepartment) {
		this.candidateSchoolDepartmentDao.save(candidateSchoolDepartment);
		return new SuccessResult();
	}
		

}
