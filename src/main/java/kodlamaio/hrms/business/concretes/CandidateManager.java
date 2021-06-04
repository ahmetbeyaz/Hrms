package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private FieldService<Candidate> candidateFieldService;
	
	
    @Autowired
	public CandidateManager(FieldService<Candidate> candidateFieldService) {
		super();
		this.candidateFieldService = candidateFieldService;
	}

	@Override
	public Result add(Candidate candidate) {
		return this.candidateFieldService.add(candidate);
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return this.candidateFieldService.getAll();
	}

}
