package kodlamaio.HRMSDB.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMSDB.entites.concretes.CandidateAbility;

public interface CandidateAbilityDao extends JpaRepository<CandidateAbility, Integer>{


	List<CandidateAbility>  getByCandidate_id(int candicateId);
}
