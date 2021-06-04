package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisementscontroller")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.delete(jobAdvertisement);
	}
	
	@GetMapping("/getActiveJobAdvertisementsOrderedByDate")
	public DataResult<List<JobAdvertisement>> findByIsActiveOrderByApplicationDeadline(boolean isActive){
		return this.jobAdvertisementService.findByIsActiveOrderByApplicationDeadline(true);
	}
	
	@GetMapping("/getActiveJobAdvertisementsWithCompanyName")
	public DataResult<List<JobAdvertisement>>findByIsActiveAndEmployer_CompanyName(boolean status, String companyName){
		return this.jobAdvertisementService.findByIsActiveAndEmployer_CompanyName(true, companyName);
	}
	
	
	
	

}
