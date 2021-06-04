package kodlamaio.HRMSDB.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMSDB.business.abstracts.CandidatePhotoService;
import kodlamaio.HRMSDB.core.utilities.helpers.imageHelper.ImageUploadService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.CandidatePhotoDao;
import kodlamaio.HRMSDB.entites.concretes.CandidatePhoto;

@Service
public class CandidatePhotoManager implements CandidatePhotoService {

	private CandidatePhotoDao candidatePhotoDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public CandidatePhotoManager(CandidatePhotoDao candidatePhotoDao,ImageUploadService imageUploadService) {
		this.candidatePhotoDao = candidatePhotoDao;
		this.imageUploadService = imageUploadService;
	}
	
	@Override
	public DataResult<List<CandidatePhoto>> getAll() {
		List<CandidatePhoto> result = this.candidatePhotoDao.findAll();
		return new SuccessDataResult<List<CandidatePhoto>>(result);
	}

	@Override
	public DataResult<CandidatePhoto> getByCandidate_id(int candidateId) {
		CandidatePhoto result = this.candidatePhotoDao.getByCandidate_id(candidateId);
		return new SuccessDataResult<CandidatePhoto>(result);
	}
	
	@Override
	public Result add(CandidatePhoto candidatePhoto) {
		
		this.candidatePhotoDao.save(candidatePhoto);
		
		return new SuccessResult();
	}

	@Override
	public Result add(CandidatePhoto candidatePhoto, MultipartFile file) {
		
		 Map<String,String> result = (Map<String,String>) this.imageUploadService.save(file).getData();
		 
	     String url = result.get("url");
		 
	     candidatePhoto.setPhotoUrl(url);
	     candidatePhoto.setUploadedDate(LocalDate.now());
	     
	     return add(candidatePhoto);
	}

	

}

