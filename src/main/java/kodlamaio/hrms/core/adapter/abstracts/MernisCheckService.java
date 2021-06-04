package kodlamaio.hrms.core.adapter.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisCheckService {
	
	boolean checkIfRealPerson(Candidate candidate);


}
