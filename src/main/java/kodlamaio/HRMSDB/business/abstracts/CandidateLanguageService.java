package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.CandidateLanguage;

public interface CandidateLanguageService {
	DataResult<List<CandidateLanguage>> getAll();
	Result add(CandidateLanguage candidateLanguage);
	DataResult<List<CandidateLanguage>> getByCandidate_id(int jobCandidateId);
	

}
