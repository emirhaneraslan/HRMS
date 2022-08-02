package hrms.dallas.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.dallas.business.abstracts.JobPositionService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.JobPosition;

@RestController //Sen bir controller'sın demek.
@RequestMapping("/api/jobposition") 
public class JobPositionController {
	
	private JobPositionService jobPositionService;
	
	@Autowired //Bizim yerimize new'leyip yerleştiriyor. Projeyi tarıyor. Kim JobPositionService'i implemente etmiş diye bakıyor. Buluyor ve new'liyor. 
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}


	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
	}
}
