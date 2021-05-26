package core;

import entities.concretes.User;

public interface AuthorizedUserService {
	boolean authorized(User user);
}
