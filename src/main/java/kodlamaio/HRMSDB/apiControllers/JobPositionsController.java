package kodlamaio.HRMSDB.apiControllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.HRMSDB.business.abstracts.JobPositionService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.entites.concretes.JobPosition;


@RestController
@RequestMapping("/api/jobposition")
public class JobPositionsController{
	
	private final JobPositionService jobPositionService;


	@Autowired 
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll() {
		return jobPositionService.getAll();
	}
	
}
