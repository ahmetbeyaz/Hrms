package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;

public interface FieldService<T> {
	Result add(T data);
	DataResult<List<T>> getAll();

}
