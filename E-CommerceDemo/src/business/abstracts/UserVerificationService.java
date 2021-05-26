package business.abstracts;

import entities.concretes.User;

public interface UserVerificationService {
	void sendMail(User user);
	void verify(User user);
}
