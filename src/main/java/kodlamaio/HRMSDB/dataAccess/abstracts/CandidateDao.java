package kodlamaio.HRMSDB.dataAccess.abstracts;

import com.google.common.base.Optional;

import kodlamaio.HRMSDB.entites.concretes.Candidate;

public interface CandidateDao extends UserDao<Candidate> {

	Optional<Candidate> findByNationalIdentity(String nationalIdentity);
}
