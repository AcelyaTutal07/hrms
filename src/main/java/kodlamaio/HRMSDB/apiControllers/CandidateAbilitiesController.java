package kodlamaio.HRMSDB.apiControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMSDB.business.abstracts.CandidateAbilityService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.CandidateAbility;

@RestController
@RequestMapping("/api/candidateAbilities")
public class CandidateAbilitiesController {

	private CandidateAbilityService candidateAbilityService;

	@Autowired
	public CandidateAbilitiesController(CandidateAbilityService candidateAbilityService) {
		this.candidateAbilityService = candidateAbilityService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateAbility>> getAll() {
		return this.candidateAbilityService.getAll();
	}
	
	@GetMapping("/getByCandidate_id")
	public DataResult<List<CandidateAbility>> getByCandidate_id(@RequestParam int candidateId) {
		return this.candidateAbilityService.getByCandidate_id(candidateId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateAbility candidateAbility) {
		return this.candidateAbilityService.add(candidateAbility);
	}
	
}

