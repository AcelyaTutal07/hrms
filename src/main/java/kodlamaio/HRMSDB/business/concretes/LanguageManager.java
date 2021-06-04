package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.LanguageService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.LanguageDao;
import kodlamaio.HRMSDB.entites.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;
	
	
	
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		List<Language> result = this.languageDao.findAll();
		return new SuccessDataResult<List<Language>>(result);
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult();	}

}
