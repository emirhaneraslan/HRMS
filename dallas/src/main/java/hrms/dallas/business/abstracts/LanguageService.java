package hrms.dallas.business.abstracts;

import java.util.List;

import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.Language;

public interface LanguageService {
	
	Result add(Language language);
	
	DataResult<List<Language>> getAll();
}
