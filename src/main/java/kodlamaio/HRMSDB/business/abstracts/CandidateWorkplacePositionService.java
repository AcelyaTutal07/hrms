package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;


import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.CandidateWorkplacePosition;

public interface CandidateWorkplacePositionService {
	DataResult<List<CandidateWorkplacePosition>> getAll();
	DataResult<List<CandidateWorkplacePosition>> getByCandidate_id(int candidateId);
	Result add(CandidateWorkplacePosition candidateWorkplacePosition);
	

}
