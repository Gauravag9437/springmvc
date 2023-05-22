package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.UserDao;
import springmvc.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public boolean isExist(User user) {
		boolean isValid = userDao.validateUser(user);

		return isValid;
	}

	public String getPassword(String username) {

		String password = userDao.getPassword(username);

		return password;
	}

}
