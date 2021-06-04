package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.CvDetailService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.CvDetailDao;
import kodlamaio.HRMSDB.entites.concretes.CvDetail;

@Service
public class CvDetailManager  implements CvDetailService{

	private CvDetailDao cvDetailDao;
	
	@Autowired
	public CvDetailManager(CvDetailDao cvDetaildao) {
        this.cvDetailDao = cvDetailDao;
	}

	@Override
	public Result add(CvDetail cvDetail) {
		this.cvDetailDao.save(cvDetail);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CvDetail>> getAll() {
		List<CvDetail> result = this.cvDetailDao.findAll();
		return new SuccessDataResult<List<CvDetail>>(result);
	}

	@Override
	public DataResult<CvDetail> getByCandidate_id(int candidate) {
		CvDetail result = this.cvDetailDao.getByCandidate_id(candidate);
		return new SuccessDataResult<CvDetail>(result);
	}

}
