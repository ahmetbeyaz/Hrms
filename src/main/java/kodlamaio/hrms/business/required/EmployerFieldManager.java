package kodlamaio.hrms.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerFieldManager implements FieldService<Employer> {
	
	
	private UserDao userDao;
	private EmployerDao employerDao;
	private ActivationCodeService activationCodeService;
	
	
	 @Autowired
	public EmployerFieldManager(UserDao userDao, EmployerDao employerDao, ActivationCodeService activationCodeService) {
		super();
		this.userDao = userDao;
		this.employerDao = employerDao;
		this.activationCodeService = activationCodeService;
	}

	@Override
	public Result add(Employer employer) {
		String[] splittedMail = employer.getEmail().split("@");
		if(this.userDao.existsByEmail(employer.getEmail())) {
			return new ErrorResult("Bu email zaten kullanılıyor");
		}
		if (!splittedMail[0].equals(employer.getWebAdress())) {
			return new ErrorResult("Yalnızca Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olabilirsiniz");
		}
		if(!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("Şifreleriniz birbiryle uyuşmamaktadır");
		}		
		this.employerDao.save(employer);
		
		this.activationCodeService.createActivationCode();
		this.activationCodeService.sendEmail(employer.getEmail());

		return new SuccessResult("İşlem başarıyla sonuçlandırılmıştır");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler başarıyla listelendi.");
	}
	

}
