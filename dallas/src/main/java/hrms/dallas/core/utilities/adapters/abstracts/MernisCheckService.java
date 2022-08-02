package hrms.dallas.core.utilities.adapters.abstracts;


import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.Employee;

public interface MernisCheckService {

	Result checkIfRealPerson(Employee employee) throws Exception;
	
}
