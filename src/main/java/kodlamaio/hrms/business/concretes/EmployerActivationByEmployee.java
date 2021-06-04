package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerActivationByEmployeeService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerActivationByEmployee implements EmployerActivationByEmployeeService {

	@Override
	public Result verifyEmployer(Employer employer) {
		
		return new SuccessResult("Şirket başarıyla doğrulandı." + employer.getCompanyName());
	}

}
