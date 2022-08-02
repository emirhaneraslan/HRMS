package hrms.dallas.business.abstracts;

import java.util.List;

import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.JobPosting;
import hrms.dallas.entities.dtos.JobPostingDto;

public interface JobPostingService {

	DataResult<List<JobPosting>> getAll();
	
	//Result add(JobPosting jobPosting);
	
	Result add(JobPostingDto jobPostingDto);
	
	DataResult<List<JobPosting>> findAllActives();
	
	DataResult<List<JobPosting>> findAllCompanyNameAndIsActive(String companyName);
	
	DataResult<List<JobPosting>> findAllByOrderByApplicationDeadlineAsc();
}
