package hrms.dallas.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.dallas.business.abstracts.LanguageStageService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.LanguageStage;

@RestController
@RequestMapping("/api/languageStage")
public class LanguageStageController {

	private LanguageStageService languageStageService;

	@Autowired
	public LanguageStageController(LanguageStageService languageStageService) {
		super();
		this.languageStageService = languageStageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LanguageStage languageStage) {
		return this.languageStageService.add(languageStage);
	}
	
	@GetMapping("/getall")
	public DataResult<List<LanguageStage>> getAll() {
		return this.languageStageService.getAll();
	}
	
	
}
