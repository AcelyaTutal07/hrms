package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.CityService;
import kodlamaio.HRMSDB.business.constraints.Messages;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.CityDao;
import kodlamaio.HRMSDB.entites.concretes.City;

@Service
public class CityManager implements CityService{


	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		List<City> result = this.cityDao.findAll();
		
		return new SuccessDataResult<List<City>>(result,Messages.citiesListed);
				
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult(Messages.citiesListed);
	}

}