package hrms.dallas.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.dallas.business.abstracts.KnownLanguageService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.KnownLanguage;
import hrms.dallas.entities.dtos.KnownLanguageDto;

@RestController
@RequestMapping("api/knownLanguage")
public class KnownLanguageController {

	private KnownLanguageService knownLanguageService;
	
	
	@Autowired
	public KnownLanguageController(KnownLanguageService knownLanguageService) {
		super();
		this.knownLanguageService = knownLanguageService;
	}



	@PostMapping("/add")
	public Result add(KnownLanguageDto knownLanguageDto) {
		return this.knownLanguageService.add(knownLanguageDto);
	}
	
	@GetMapping("/getall")
	public DataResult<List<KnownLanguage>> getAll() {
		return this.knownLanguageService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<KnownLanguage> getById(int id) {
		return this.knownLanguageService.getById(id);
	}
}
