package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.CandidateWorkplacePositionService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.CandidateWorkplacePositionDao;
import kodlamaio.HRMSDB.entites.concretes.CandidateWorkplacePosition;

@Service
public class CandidateWorkplacePositionManager implements CandidateWorkplacePositionService {

	private CandidateWorkplacePositionDao  candidateWorkplacePositionDao;
	
	
	@Autowired
	public CandidateWorkplacePositionManager(CandidateWorkplacePositionDao candidateWorkplacePositionDao) {
		
		this.candidateWorkplacePositionDao = candidateWorkplacePositionDao;
	}

	@Override
	public DataResult<List<CandidateWorkplacePosition>> getAll() {
		List<CandidateWorkplacePosition> result = this.candidateWorkplacePositionDao.findAll();
		return new SuccessDataResult<List<CandidateWorkplacePosition>>(result);
	}

	@Override
	public DataResult<List<CandidateWorkplacePosition>> getByCandidate_id(int candidateId) {
		List<CandidateWorkplacePosition> result = this.candidateWorkplacePositionDao.getByCandidate_id(candidateId);
		return new SuccessDataResult<List<CandidateWorkplacePosition>>(result);
	}

	@Override
	public Result add(CandidateWorkplacePosition candidateWorkplacePosition) {
		this.candidateWorkplacePositionDao.save(candidateWorkplacePosition);
		return new SuccessResult();
		}

}
