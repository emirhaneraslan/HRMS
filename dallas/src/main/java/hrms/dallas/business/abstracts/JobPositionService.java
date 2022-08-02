package hrms.dallas.business.abstracts;

import java.util.List;

import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.JobPosition;

public interface JobPositionService {
	
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);


}
