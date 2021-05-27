package kodlamaio.HRMSDB.apiControllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.HRMSDB.business.abstracts.EmployerService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.entites.concretes.Employer;


@RestController
@RequestMapping("/api/employer")
public class EmployerController {

		
		private EmployerService employerService;
		
		public  EmployerController(EmployerService employerService) {
			this.employerService = employerService;
		
	   }
		@GetMapping
		public DataResult<List<Employer>> getAll() {
			return employerService.getAll();
		}
}
