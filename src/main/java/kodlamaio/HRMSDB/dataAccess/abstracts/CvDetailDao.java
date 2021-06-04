package kodlamaio.HRMSDB.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMSDB.entites.concretes.CvDetail;

public interface CvDetailDao extends JpaRepository<CvDetail, Integer> {

	CvDetail getByCandidate_id(int candidate);
}
