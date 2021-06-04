package kodlamaio.HRMSDB.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMSDB.entites.concretes.CandidateSchoolDepartment;

public interface CandidateSchoolDepartmentDao extends JpaRepository<CandidateSchoolDepartment, Integer> {

	List<CandidateSchoolDepartment>  getByCandidate_idOrderByDateOfGraduationDesc(int candidateId);
}
