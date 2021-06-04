package kodlamaio.hrms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employer")
public class EmployersController {
	
	
	private EmployerService empoyerService;

	@Autowired
	public EmployersController(EmployerService empoyerService) {
		super();
		this.empoyerService = empoyerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.empoyerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Employer employer) {
		return this.empoyerService.add(employer);
	}

}
