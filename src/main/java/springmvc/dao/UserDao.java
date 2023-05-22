package springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.User;

@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public boolean validateUser(User user) {


		String existPassword = "";

		User userNow = this.hibernateTemplate.get(User.class, user.getUsername());
		
		if (userNow != null) {
			existPassword = userNow.getPassword();
			if (existPassword.compareTo(user.getPassword()) == 0) {
				return true;
			}
		}

		return false;
	}

	@Transactional
	public String getPassword(String username) {

		User user = this.hibernateTemplate.get(User.class, username);

		if (user != null) {
			String password = user.getPassword();

			return password;
		} else {
			return null;
		}

	}

}
