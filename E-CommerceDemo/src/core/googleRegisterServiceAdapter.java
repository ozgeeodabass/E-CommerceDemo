package core;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;
import googleLogin.GoogleRegisterManager;

public class googleRegisterServiceAdapter implements AuthorizedUserService {
	
	ValidationManager validation;
	UserDao userDao;
	
	public googleRegisterServiceAdapter() {
		
	}
	
	

	public googleRegisterServiceAdapter(ValidationManager validation, UserDao userDao) {
		super();
		this.validation = validation;
		this.userDao = userDao;
	}







	@Override
	public boolean authorized(User user) {
		GoogleRegisterManager register = new GoogleRegisterManager();
		
		if(register.register(user)) {
			return true;
		}
		return false;
	}
	
}
