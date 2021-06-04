package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.AbilityService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.AbilityDao;
import kodlamaio.HRMSDB.entites.concretes.Ability;

@Service
public class AbilityManager implements AbilityService {

	private AbilityDao abilityDao;
	
	
    @Autowired
	public AbilityManager(AbilityDao abilityDao) {
		
		this.abilityDao = abilityDao;
	}
	
	@Override
	public DataResult<List<Ability>> getAll() {
		List<Ability> result = this.abilityDao.findAll();
		return  new SuccessDataResult<List<Ability>>(result);
		
	}

	@Override
	public Result add(Ability ability) {
		this.abilityDao.save(ability);
		return new SuccessResult();
	}


}
