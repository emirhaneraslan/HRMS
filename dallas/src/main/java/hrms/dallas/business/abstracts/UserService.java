package hrms.dallas.business.abstracts;

import java.util.List;

import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	Result add(User user);

}
