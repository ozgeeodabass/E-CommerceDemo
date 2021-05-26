package business.concretes;

import business.abstracts.UserService;
import core.AuthorizedUserService;
import core.ValidationManager;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class AuthorizedUserManager implements UserService{

	
	ValidationManager validation;
	UserDao userDao;
	AuthorizedUserService auService;
	
	public AuthorizedUserManager(ValidationManager validation, UserDao userDao, AuthorizedUserService auService) {
		this.validation = validation;
		this.userDao = userDao;
		this.auService = auService;
	}

	@Override
	public void save(User user) {
		if(auService.authorized(user)) {
			if(userDao.checkIfEmailIsRegistered(user)) {
				System.out.println("Kayýt iþlemi baþarýsýz. Bu E-posta daha önce kullanýlmýþ");
			}else {
				userDao.add(user);
			}
			return;
		}
		
		System.out.println("Bu email adresine tanýmlý bir google hesabý bulunamadý");
	}

	@Override
	public void verify(User user) {
		
		
	}
}
