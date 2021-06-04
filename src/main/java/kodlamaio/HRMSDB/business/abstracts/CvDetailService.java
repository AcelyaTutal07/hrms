package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.CvDetail;

public interface CvDetailService {
	Result add(CvDetail cvDetail);
	DataResult<List<CvDetail>> getAll();
	DataResult<CvDetail> getByCandidate_id(int candidate);
	

}
