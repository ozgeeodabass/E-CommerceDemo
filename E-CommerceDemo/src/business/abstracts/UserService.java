package business.abstracts;

import entities.concretes.User;

public interface UserService {
	
	void save(User user);
	void verify(User user);
	
	
}
