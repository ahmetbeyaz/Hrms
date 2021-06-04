package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;


@Service
public class ActivationCodeManager implements ActivationCodeService {
	
	private ActivationCodeDao activationCodeDao;
	
	
    @Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}

	@Override
	public String createActivationCode() {
		ActivationCode activationCode = new ActivationCode();
		activationCode.setActivationCode("activationcodeone");
		return activationCode.getActivationCode();
	}

	@Override
	public void sendEmail(String email) {
		System.out.println("Doğrulama kodu için email gönderildi" + email);
		
	}

	@Override
	public Result verifyUserWithActivationCode(String code) {
		if(this.activationCodeDao.existsByActivationCode(code)) {
			return new SuccessResult("Doğrulama işleminiz başarılı.");
		}
		return new ErrorResult("Doğrulama işleminiz başarısız.");
	}
	}


