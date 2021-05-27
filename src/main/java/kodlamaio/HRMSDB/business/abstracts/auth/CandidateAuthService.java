package kodlamaio.HRMSDB.business.abstracts.auth;


import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.dtos.RegisterForCandidateDto;



public interface CandidateAuthService {
   Result register(RegisterForCandidateDto registerForCandidateDto);
  
}
