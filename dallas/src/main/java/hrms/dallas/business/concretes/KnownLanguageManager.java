package hrms.dallas.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.dallas.business.abstracts.KnownLanguageService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.core.utilities.results.SuccessDataResult;
import hrms.dallas.core.utilities.results.SuccessResult;
import hrms.dallas.dataAccess.abstracts.KnownLanguageDao;
import hrms.dallas.dataAccess.abstracts.LanguageDao;
import hrms.dallas.dataAccess.abstracts.LanguageStageDao;
/*import hrms.dallas.dataAccess.abstracts.LanguageDao;
import hrms.dallas.dataAccess.abstracts.LanguageStageDao;*/
import hrms.dallas.entities.concretes.KnownLanguage;
import hrms.dallas.entities.concretes.Language;
import hrms.dallas.entities.concretes.LanguageStage;
import hrms.dallas.entities.dtos.KnownLanguageDto;

@Service
public class KnownLanguageManager implements KnownLanguageService{

	private KnownLanguageDao knownLanguageDao;
	private LanguageDao languageDao;
	private LanguageStageDao languageStageDao;
	
	
	
	@Autowired
	public KnownLanguageManager(KnownLanguageDao knownLanguageDao,
			LanguageDao languageDao,
			LanguageStageDao languageStageDao) {
		super();
		this.knownLanguageDao = knownLanguageDao;
		this.languageDao = languageDao;
		this.languageStageDao = languageStageDao;
	}

	@Override
	public Result add(KnownLanguageDto knownLanguageDto) {
		Language language= this.languageDao.findLanguageById(knownLanguageDto.getLanguageId());
		LanguageStage languageStage= this.languageStageDao.findLanguageStageById((knownLanguageDto.getLanguageStageId()));
		
		KnownLanguage knownLanguageForSave = new KnownLanguage();
		knownLanguageForSave.setLanguage(language);
		knownLanguageForSave.setLanguageStage(languageStage);
		
		knownLanguageDao.save(knownLanguageForSave);
		return new SuccessResult("Bilinen Dil kayıt edildi.");
	}

	@Override
	public DataResult<List<KnownLanguage>> getAll() {
		return new SuccessDataResult<List<KnownLanguage>>(this.knownLanguageDao.findAll(),"Bilinen diller listelendi.");
	}

	@Override
	public DataResult<KnownLanguage> getById(int id) {
		return new SuccessDataResult<KnownLanguage>(this.knownLanguageDao.findKnownLanguageById(id),"Data Listelendi");
	}

}
