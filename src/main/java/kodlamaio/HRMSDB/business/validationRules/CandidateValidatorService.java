package kodlamaio.HRMSDB.business.validationRules;

import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.Candidate;

public interface CandidateValidatorService {
	 Result candidateNullCheck(Candidate candidate);
}
