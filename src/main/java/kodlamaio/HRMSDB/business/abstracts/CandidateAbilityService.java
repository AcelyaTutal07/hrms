package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.CandidateAbility;

public interface CandidateAbilityService {
	
    DataResult<List<CandidateAbility>> getAll();
	
	DataResult<List<CandidateAbility>> getByCandidate_id(int candidateId);
	
	Result add(CandidateAbility candidateAbility);

	

}
