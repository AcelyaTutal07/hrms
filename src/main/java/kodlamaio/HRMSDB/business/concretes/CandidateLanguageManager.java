package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.CandidateLanguageService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.HRMSDB.entites.concretes.CandidateLanguage;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {

	private CandidateLanguageDao candidateLanguageDao;
	
	
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
		super();
		this.candidateLanguageDao = candidateLanguageDao;
	}
	
	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		List<CandidateLanguage> result = this.candidateLanguageDao.findAll();
		return new SuccessDataResult<List<CandidateLanguage>>(result);
	}

    @Override
	public Result add(CandidateLanguage candidateLanguage) {
		this.candidateLanguageDao.save(candidateLanguage);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateLanguage>> getByCandidate_id(int jobCandidateId) {
		List<CandidateLanguage> result = this.candidateLanguageDao.getByCandidate_id(jobCandidateId);
		return new SuccessDataResult<List<CandidateLanguage>>(result);
	}

}
