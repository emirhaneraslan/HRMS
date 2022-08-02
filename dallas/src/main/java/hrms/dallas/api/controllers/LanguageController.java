package hrms.dallas.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.dallas.business.abstracts.LanguageService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.Language;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
	
	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Language>> getAll() {
		return this.languageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}
	

}
