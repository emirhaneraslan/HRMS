package hrms.dallas.business.concretes;

//beans: proje class'ı

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.dallas.business.abstracts.JobPositionService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.ErrorResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.core.utilities.results.SuccessDataResult;
import hrms.dallas.core.utilities.results.SuccessResult;
import hrms.dallas.dataAccess.abstracts.JobPositionDao;
import hrms.dallas.entities.concretes.JobPosition;

@Service // Bu class service görevi görecek demek. Yani business işini yapacak kısım.
public class JobPositionManager implements JobPositionService{

	//@Autowired burayada koysak injecşınını yapar. Ama her eklediğniz injecşın için eklmeniz gerekir.
	private JobPositionDao jobPositionDao;
	
	@Autowired //Autowired spring'den geliyor. Spring gidip arka planda JobPosition'ın insantance'ı olabilecek bir tane sınıfı üretiyor ve onu veriyor. Bağımlılık oluşturur.
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"İş pozisyonları listelendi.");
	}
	
	private Result isJobPositionsExist (String jobPositions) {
		if(jobPositionDao.getByTitleofjob(jobPositions) != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(!this.isJobPositionsExist(jobPosition.getTitleofjob()).isSuccess()) {
			return new ErrorResult("İş pozisyonu zaten mevcut.");
		}
		
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu eklendi");
	}


	

}
