package hrms.dallas.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.dallas.business.abstracts.LanguageStageService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.core.utilities.results.SuccessDataResult;
import hrms.dallas.core.utilities.results.SuccessResult;
import hrms.dallas.dataAccess.abstracts.LanguageStageDao;
import hrms.dallas.entities.concretes.LanguageStage;

@Service
public class LanguageStageManager implements LanguageStageService{

	private LanguageStageDao languageStageDao;
	
	@Autowired
	public LanguageStageManager(LanguageStageDao languageStageDao) {
		super();
		this.languageStageDao = languageStageDao;
	}

	@Override
	public Result add(LanguageStage languageStage) {
		this.languageStageDao.save(languageStage);
		return new SuccessResult("Dil Seviyesi kayıt edildi.");
	}

	@Override
	public DataResult<List<LanguageStage>> getAll() {
		return new SuccessDataResult<List<LanguageStage>>(this.languageStageDao.findAll(),"Dil Seviyeleri Listelendi.");
	}

}
