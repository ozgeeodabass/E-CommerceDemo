package business.concretes;

import java.util.ArrayList;
import java.util.List;

import business.abstracts.UserLoginService;
import business.abstracts.UserService;
import business.abstracts.UserVerificationService;
import core.ValidationManager;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {

	private List<String> emails = new ArrayList<String>();
	ValidationManager validation;
	UserVerificationService verify;
	UserDao userDao;
	

	public UserManager(ValidationManager validation, UserVerificationService verify, UserDao userDao) {
		this.validation = validation;
		this.verify = verify;
		this.userDao = userDao;
	}


	@Override
	public void save(User user) {
		if(validation.valid(user, emails, userDao)) {
			verify.sendMail(user);
		}
		
		
	}


	@Override
	public void verify(User user) {
		verify.verify(user);
		userDao.add(user);
	}

	
	
	
	
	
	
}
