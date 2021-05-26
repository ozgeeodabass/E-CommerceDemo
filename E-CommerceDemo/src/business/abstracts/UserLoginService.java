package business.abstracts;

import entities.concretes.User;

public interface UserLoginService {
	void logIn(User user);
}
