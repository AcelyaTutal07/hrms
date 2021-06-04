package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.CandidatePhoto;

public interface CandidatePhotoService {

    DataResult<List<CandidatePhoto>> getAll();
	
	DataResult<CandidatePhoto> getByCandidate_id(int candidateId);
	
	Result add(CandidatePhoto candidatePhoto);
	
	Result add(CandidatePhoto candidatePhoto, MultipartFile file);
}
