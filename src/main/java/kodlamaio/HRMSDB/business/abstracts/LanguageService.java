package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;


import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.Language;

public interface LanguageService {
	DataResult<List<Language>> getAll();
	Result add(Language language);

}
