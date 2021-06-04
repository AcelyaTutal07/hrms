package kodlamaio.HRMSDB.apiControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMSDB.business.abstracts.CandidateWorkplacePositionService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.CandidateWorkplacePosition;

@RestController
@RequestMapping("/api/candidateWorkplacePositions")
public class CandidateWorkplacesPositionsController{

	private CandidateWorkplacePositionService candidateWorkplacePositionService;

	@Autowired
	public CandidateWorkplacesPositionsController(CandidateWorkplacePositionService candidateWorkplacePositionService) {
		this.candidateWorkplacePositionService = candidateWorkplacePositionService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateWorkplacePosition>> getAll() {
		return this.candidateWorkplacePositionService.getAll();
	}
	
	@GetMapping("/getByCandidate_id")
	public DataResult<List<CandidateWorkplacePosition>> getByCandidate_id(@RequestParam int candidateId) {
		return this.candidateWorkplacePositionService.getByCandidate_id(candidateId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateWorkplacePosition candidateWorkplacePosition) {
		return this.candidateWorkplacePositionService.add(candidateWorkplacePosition);
	}
	
}
