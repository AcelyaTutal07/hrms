package kodlamaio.HRMSDB.apiControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMSDB.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getByIsActive")
    public DataResult<List<JobAdvertisement>> getByIsActive() {
        return this.jobAdvertisementService.findAllByIsActive();
    }

    @GetMapping("/getByLastApplyDate")
    public DataResult<List<JobAdvertisement>> getByLastApplyDate() {
        return this.jobAdvertisementService.getByLastApplicationDate();
    }

    @GetMapping("/getByIsActiveAndEmployer_Id")
    public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_Id(int id) {
        return this.jobAdvertisementService.getByisActiveAndEmployerId(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }
    
   @PutMapping("/updated")
    public Result update(@RequestParam("jobAdvertisemenetId") int jobAdvertisemenetId,
			@RequestBody JobAdvertisement jobAdvertisement) {
    	
    	return this.jobAdvertisementService.update(jobAdvertisemenetId, jobAdvertisement);
    }
    
    

}
