package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerActivationByEmployeeService {
	
	Result verifyEmployer(Employer employer); 

}
