package hrms.dallas.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.dallas.business.abstracts.JobPostingService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.JobPosting;
import hrms.dallas.entities.dtos.JobPostingDto;

@RestController
@RequestMapping("/api/job_advertisments")
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll() { 
		return this.jobPostingService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(JobPostingDto jobPostingDto) {
		return this.jobPostingService.add(jobPostingDto);
	}
	
	@GetMapping("/getAllActives")
	public DataResult<List<JobPosting>> findAllActives() {
		return this.jobPostingService.findAllActives();
	}
	
	@GetMapping("/getAllActivesByCompanyName")
	public DataResult<List<JobPosting>> findAllCompanyNameAndIsActive(String companyName) {
		return this.jobPostingService.findAllCompanyNameAndIsActive(companyName);
	}
	
	@GetMapping("/getAllOrderByApplicationDeadlineAsc")
	public DataResult<List<JobPosting>> findAllByOrderByApplicationDeadlineAsc() {
		return this.jobPostingService.findAllByOrderByApplicationDeadlineAsc();
	}
}
