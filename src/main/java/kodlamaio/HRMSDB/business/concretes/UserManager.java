package kodlamaio.HRMSDB.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.UserService;
import kodlamaio.HRMSDB.business.constraints.Messages;
import kodlamaio.HRMSDB.core.utilities.business.BusinessEngine;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.ErrorResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.UserDao;
import kodlamaio.HRMSDB.entites.concretes.User;


@Service
public class UserManager<T extends User> implements UserService<T>{

	private UserDao<T> userDao;
	
	@Autowired
	public UserManager(UserDao<T> userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public DataResult<List<T>> getAll() {
		
		return new SuccessDataResult<List<T>>(this.userDao.findAll(), Messages.userListed);
	}

	@Override
	public Result add(T t) {
	 
		Result result = BusinessEngine.run(isEmailExist(t.getEmail()));
		if(result.isSuccess()) {
		this.userDao.save(t);
		return new SuccessResult(Messages.userAdded);
	}
		return result;
	}

		
	public Result isEmailExist(String email) {
		if(userDao.findByEmail(email).isPresent()) {
			return new ErrorResult(Messages.emailExist);
		}
		return new SuccessResult();
	}

}
