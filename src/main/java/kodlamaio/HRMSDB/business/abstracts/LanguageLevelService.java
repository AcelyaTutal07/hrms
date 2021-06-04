package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.LanguageLevel;

public interface LanguageLevelService {
	DataResult<List<LanguageLevel>> getAll();
	Result add(LanguageLevel languageLevel);

}
