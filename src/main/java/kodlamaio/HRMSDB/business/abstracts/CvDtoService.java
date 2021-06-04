package kodlamaio.HRMSDB.business.abstracts;

import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.dtos.CvDto;

public interface CvDtoService {
	Result add(CvDto cvDto);

}
