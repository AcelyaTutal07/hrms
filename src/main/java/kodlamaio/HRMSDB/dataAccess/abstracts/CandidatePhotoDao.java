package kodlamaio.HRMSDB.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMSDB.entites.concretes.CandidatePhoto;

public interface CandidatePhotoDao extends JpaRepository<CandidatePhoto, Integer> {
	

	CandidatePhoto getByCandidate_id(int candidateId);
}
