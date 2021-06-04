package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	
    @Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Tebrikler  İşlem başarılı.");
		
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("Tebrikler  İşlem başarılı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(),"Tüm iş ilanları görüntülendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActive(isActive),"Veriler başarıyla getirildi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveOrderByApplicationDeadline(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveOrderByApplicationDeadline(isActive));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_CompanyName(boolean isActive,
			String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(isActive, companyName));
	}

}
