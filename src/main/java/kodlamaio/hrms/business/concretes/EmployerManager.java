package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	
	private FieldService<Employer> employerFieldService;
	
	
    @Autowired
	public EmployerManager(FieldService<Employer> employerFieldService) {
		super();
		this.employerFieldService = employerFieldService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return this.employerFieldService.getAll();
	}

	@Override
	public Result add(Employer employer) {
		return this.employerFieldService.add(employer);
	}

}
