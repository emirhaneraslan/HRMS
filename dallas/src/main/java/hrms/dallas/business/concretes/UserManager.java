package hrms.dallas.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.dallas.business.abstracts.UserService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.core.utilities.results.SuccessDataResult;
import hrms.dallas.core.utilities.results.SuccessResult;
import hrms.dallas.dataAccess.abstracts.UserDao;
import hrms.dallas.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Kullanıcalar Listelendi.");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı kaydedildi.");
	}
	

}
