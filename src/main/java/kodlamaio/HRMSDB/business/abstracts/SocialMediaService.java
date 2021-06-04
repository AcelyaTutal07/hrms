package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.SocialMedia;

public interface SocialMediaService {

    DataResult<List<SocialMedia>> getAll();
	
	DataResult<List<SocialMedia>> getByCandidate_id(int CandidateId);
	
	Result add(SocialMedia socialMedia);
}
