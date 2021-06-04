package kodlamaio.HRMSDB.business.abstracts;

import java.util.List;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.LinkType;

public interface LinkTypeService {
	DataResult<List<LinkType>> getAll();
	Result add(LinkType linkType);

}
