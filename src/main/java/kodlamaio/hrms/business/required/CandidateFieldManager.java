package kodlamaio.hrms.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.adapter.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateFieldManager implements FieldService<Candidate> {
	
	
	private UserDao userDao;
	private CandidateDao candidateDao;
	private ActivationCodeService activationCodeService;
	private MernisCheckService mernisCheckService;
	
	 
	
    @Autowired
	public CandidateFieldManager(UserDao userDao, CandidateDao candidateDao,
			ActivationCodeService activationCodeService, MernisCheckService mernisCheckService) {
		super();
		this.userDao = userDao;
		this.candidateDao = candidateDao;
		this.activationCodeService = activationCodeService;
		this.mernisCheckService = mernisCheckService;
	}

	@Override
	public Result add(Candidate candidate) {
		
				if(!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
					return new ErrorResult("Şifreleriniz uyuşmuyor.");
				} 
				if(candidateDao.existsByNationalId(candidate.getNationalId())) {
					return new ErrorResult("Bu TC kimlik numarası zaten kullanılıyor.");
				}
				if(userDao.existsByEmail(candidate.getEmail())) {
					return new ErrorResult("Bu emaile sahip başka bir kullanıcı var.");
				}
				if(!mernisCheckService.checkIfRealPerson(candidate)) {
					return new ErrorResult("Mernis doğrulaması gerçekleitirilemedi.");
				}
				
					
					this.candidateDao.save(candidate);
					this.activationCodeService.createActivationCode();
					this.activationCodeService.sendEmail(candidate.getEmail());
					return new SuccessResult("İşlem başarıyla sonuçlandırılmıştır.");
				
				
				
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Adaylar başarıyla listelenmiştir");
	}

}
