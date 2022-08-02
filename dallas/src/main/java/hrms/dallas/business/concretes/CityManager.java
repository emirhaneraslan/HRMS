package hrms.dallas.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.dallas.business.abstracts.CityService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.core.utilities.results.SuccessDataResult;
import hrms.dallas.core.utilities.results.SuccessResult;
import hrms.dallas.dataAccess.abstracts.CityDao;
import hrms.dallas.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("Şehir kayıt edildi.");
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Şehirler Lsitelendi.");
	}

}
