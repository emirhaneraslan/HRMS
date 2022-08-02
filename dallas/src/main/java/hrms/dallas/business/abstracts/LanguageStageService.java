package hrms.dallas.business.abstracts;

import java.util.List;

import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.LanguageStage;

public interface LanguageStageService {
	
	Result add(LanguageStage languageStage);
	
	DataResult<List<LanguageStage>> getAll();

}
