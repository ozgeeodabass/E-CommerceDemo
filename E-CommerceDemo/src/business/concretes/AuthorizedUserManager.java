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
				System.out.println("Kay�t i�lemi ba�ar�s�z. Bu E-posta daha �nce kullan�lm��");
			}else {
				userDao.add(user);
			}
			return;
		}
		
		System.out.println("Bu email adresine tan�ml� bir google hesab� bulunamad�");
	}

	@Override
	public void verify(User user) {
		
		
	}
}
