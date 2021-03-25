package com.deloitte.Patyal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.Patyal.model.User;
import com.deloitte.Patyal.repository.UserRepository;

/**
 * LoginService is the class which is executed from the LoginController class.
 * It has only one method. This class will create an object for the
 * userRepository class when required. The main purpose of this class is 
 * to write down the service layer methods required for this application.
 * 
 * @author Billy Jacob
 * @version %I%, %G%
 * @since 1.0
 */
@Service
public class LoginService {
	@Autowired
	UserRepository userRepository;

	/**
	 * This method will validate the userName and the password. If the userName does not exist in
	 * the database then the method returns false and if the password provided for that corresponding
	 * user is wrong then the method returns false. If both these scenarios are correct it returns true.
	 * @param userid This attribute will hold the userName provided by the user from the Login page.
	 * @param password This attribute will hold the value of the password given as input bu the user.
	 * @return It returns a boolean value. Either True or False.
	 */
	public boolean validateUser(String userid, String password) {
		
		String real_password = userRepository.findPassword(userid);
		if (!(real_password == null)) {
			return real_password.equalsIgnoreCase(password);
		} else {
			return false;
		}
	}

}