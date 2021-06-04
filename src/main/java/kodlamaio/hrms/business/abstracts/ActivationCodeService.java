package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;

public interface ActivationCodeService {
	
String createActivationCode();
	
	void sendEmail(String email);
	
	Result verifyUserWithActivationCode(String code);

}
