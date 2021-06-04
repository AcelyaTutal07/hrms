package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.LanguageLevelService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.LanguageLevelDao;
import kodlamaio.HRMSDB.entites.concretes.LanguageLevel;

@Service
public class LanguageLevelManager implements LanguageLevelService {

	private  LanguageLevelDao languageLevelDao;

	@Autowired
	public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
		super();
		this.languageLevelDao = languageLevelDao;
	}
	
	@Override
	public DataResult<List<LanguageLevel>> getAll() {
		List<LanguageLevel> result = this.languageLevelDao.findAll();
		return new SuccessDataResult<List<LanguageLevel>>(result);
	}

	@Override
	public Result add(LanguageLevel languageLevel) {
		this.languageLevelDao.save(languageLevel);
		return new SuccessResult();
	}

	

}
