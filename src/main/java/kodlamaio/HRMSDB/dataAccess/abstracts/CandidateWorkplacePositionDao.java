package kodlamaio.HRMSDB.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMSDB.entites.concretes.CandidateWorkplacePosition;

public interface CandidateWorkplacePositionDao extends JpaRepository<CandidateWorkplacePosition, Integer> {
	
	List<CandidateWorkplacePosition> getByCandidate_id(int candidateId); 

	
}
