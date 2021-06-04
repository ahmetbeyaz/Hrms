package kodlamaio.hrms.core.adapter.concretes;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapter.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService {


	
	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
	
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		
		
		
		try {
		@SuppressWarnings("deprecation")
		boolean	result=client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalId()), 
				candidate.getFirstName().toUpperCase(new Locale("tr")),
					candidate.getLastName().toUpperCase(new Locale("tr")), 
					candidate.getBirthDate().getYear());
		
		return result;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return false;
		
		
	
	}

}
