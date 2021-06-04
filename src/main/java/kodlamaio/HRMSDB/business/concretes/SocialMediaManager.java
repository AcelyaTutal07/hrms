package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.SocialMediaService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.HRMSDB.entites.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {

	
	private SocialMediaDao socialMediaDao;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
	
		this.socialMediaDao = socialMediaDao;
	}

	@Override
	public DataResult<List<SocialMedia>> getAll() {
		List<SocialMedia> result = this.socialMediaDao.findAll();
		return new SuccessDataResult<List<SocialMedia>>(result);
	}

	@Override
	public DataResult<List<SocialMedia>> getByCandidate_id(int CandidateId) {
		List<SocialMedia> result = this.socialMediaDao.getByCandidate_id(CandidateId);
		return new SuccessDataResult<List<SocialMedia>>(result);
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult();
		
	}

}
