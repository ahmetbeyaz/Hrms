package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdversitement);
	Result delete(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive);
	DataResult<List<JobAdvertisement>> findByIsActiveOrderByApplicationDeadline(boolean isActive);
	DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName);

}
