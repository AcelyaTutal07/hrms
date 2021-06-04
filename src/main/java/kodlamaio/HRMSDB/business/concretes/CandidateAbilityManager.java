package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.CandidateAbilityService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.CandidateAbilityDao;
import kodlamaio.HRMSDB.entites.concretes.CandidateAbility;

@Service
public class CandidateAbilityManager implements CandidateAbilityService{

	private CandidateAbilityDao candidateAbilityDao;
	
	public CandidateAbilityManager(CandidateAbilityDao candidateAbilityDao) {
		
		this.candidateAbilityDao = candidateAbilityDao;
	}

	@Override
	public DataResult<List<CandidateAbility>> getAll() {
		List<CandidateAbility> result = this.candidateAbilityDao.findAll();
		return new SuccessDataResult<List<CandidateAbility>>(result);
	}

	@Override
	public DataResult<List<CandidateAbility>> getByCandidate_id(int candidateId) {
		List<CandidateAbility> result = this.candidateAbilityDao.getByCandidate_id(candidateId);
		return new SuccessDataResult<List<CandidateAbility>>(result);
	}

	@Override
	public Result add(CandidateAbility candidateAbility) {
		this.candidateAbilityDao.save(candidateAbility);
		return new SuccessResult();
	}

}
