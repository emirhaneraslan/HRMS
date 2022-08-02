package hrms.dallas.business.abstracts;

import java.util.List;

import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.KnownLanguage;
import hrms.dallas.entities.dtos.KnownLanguageDto;

public interface KnownLanguageService {
	
	Result add (KnownLanguageDto knownLanguageDto);
	
	DataResult<List<KnownLanguage>> getAll();
	
	DataResult<KnownLanguage> getById(int id);
	
	
}
