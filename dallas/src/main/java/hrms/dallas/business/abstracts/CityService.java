package hrms.dallas.business.abstracts;

import java.util.List;

import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.City;

public interface CityService {
	
	Result add (City city);
	DataResult<List<City>> getAll();

	
}
