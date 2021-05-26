package business.concretes;

import business.abstracts.UserLoginService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserLoginManager implements UserLoginService {
	
	private UserDao userDao;
	
	
	

	public UserLoginManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}




	@Override
	public void logIn(User user) {
		for (User user1 : userDao.getAll()) {
			if(user.getEmail() == user1.getEmail() && user.getPassword() == user1.getPassword()) {
				System.out.println("Giriþ yapýldý");
				return;
			}
			System.out.println("Giriþ baþarýsýz");
			return;
			
		}
		
	}

}
