package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.City;

public interface CityService {
	
    DataResult<List<City>> getAll();
	
	Result add(City city);


}
