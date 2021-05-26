package core;

import business.abstracts.UserVerificationService;
import entities.concretes.User;

public class EmailVerificationManager implements UserVerificationService {

	@Override
	public void sendMail(User user) {
		System.out.println(user.getEmail() + " adresine do�rulama kodu g�nderildi");
		
	}

	@Override
	public void verify(User user) {
		System.out.println("Hesap do�ruland�");
		
	}

}
