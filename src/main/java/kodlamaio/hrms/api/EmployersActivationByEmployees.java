package kodlamaio.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerActivationByEmployeeService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employeractivationbyemployee")
public class EmployersActivationByEmployees {
	
	private EmployerActivationByEmployeeService employerActivationByEmployeeService;
	
	@Autowired
	public EmployersActivationByEmployees(EmployerActivationByEmployeeService employerActivationByEmployeeService) {
		super();
		this.employerActivationByEmployeeService = employerActivationByEmployeeService;
	}

	@PostMapping("/verify")
	public Result verifyEmployer(Employer employer) {
		return this.employerActivationByEmployeeService.verifyEmployer(employer);
	}

}
