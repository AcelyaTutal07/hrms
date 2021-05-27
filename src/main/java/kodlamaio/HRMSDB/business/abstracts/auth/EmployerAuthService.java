package kodlamaio.HRMSDB.business.abstracts.auth;

import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.dtos.RegisterForEmployerDto;


public interface EmployerAuthService {

	 Result register(RegisterForEmployerDto registerForEmployerDto);
	  
}
