package hrms.dallas.business.abstracts;

import java.util.List;

import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.Employee;

public interface EmployeeService {
	
	DataResult<List<Employee>> getAll();
	Result add(Employee employee) throws Exception;


}
