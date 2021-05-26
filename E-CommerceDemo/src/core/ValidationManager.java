package core;

import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class ValidationManager {

	
	public boolean valid(User user, List<String> emails, UserDao userDao) {
		if(user.getFirstName().isEmpty() || user.getLastName().isEmpty() || 
				user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
			System.out.println("Kayýt iþlemi baþarýsýz. Lütfen zorunlu alanlarý doldurunuz.");
			return false;
		}
		
		if(user.getPassword().length() < 6) {
			System.out.println("Kayýt iþlemi baþarýsýz. Parola en az 6 karakterden oluþmalýdýr.");
			return false;
		}
		
		RegexManager regexManager = new RegexManager();
		if(!regexManager.checkEmailFormat(user.getEmail())) {
			System.out.println("Kayýt iþlemi baþarýsýz. E-posta formatý uygun deðil.");
			return false;
		}
		
		if(user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
			System.out.println("Kayýt iþlemi baþarýsýz. Ýsim ve Soyisim en az 2 karakterli olmalýdýr.");
			return false;
		}
		if(userDao.checkIfEmailIsRegistered(user)) {
			System.out.println("Kayýt iþlemi baþarýsýz. E-posta adresi sisteme zaten kayýtlý.");
			return false;
		}
		return true;
		
	}
}
