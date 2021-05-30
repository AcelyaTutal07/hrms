package kodlamaio.HRMSDB.apiControllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMSDB.business.abstracts.CandidateService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.entites.concretes.Candidate;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
	
	private CandidateService candidateService;
	
	public  CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
		
	
   }
	@GetMapping
	public DataResult<List<Candidate>> getAll() {
		return candidateService.getAll();
	}
	
}

