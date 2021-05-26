package core;

import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class ValidationManager {

	
	public boolean valid(User user, List<String> emails, UserDao userDao) {
		if(user.getFirstName().isEmpty() || user.getLastName().isEmpty() || 
				user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
			System.out.println("Kay�t i�lemi ba�ar�s�z. L�tfen zorunlu alanlar� doldurunuz.");
			return false;
		}
		
		if(user.getPassword().length() < 6) {
			System.out.println("Kay�t i�lemi ba�ar�s�z. Parola en az 6 karakterden olu�mal�d�r.");
			return false;
		}
		
		RegexManager regexManager = new RegexManager();
		if(!regexManager.checkEmailFormat(user.getEmail())) {
			System.out.println("Kay�t i�lemi ba�ar�s�z. E-posta format� uygun de�il.");
			return false;
		}
		
		if(user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
			System.out.println("Kay�t i�lemi ba�ar�s�z. �sim ve Soyisim en az 2 karakterli olmal�d�r.");
			return false;
		}
		if(userDao.checkIfEmailIsRegistered(user)) {
			System.out.println("Kay�t i�lemi ba�ar�s�z. E-posta adresi sisteme zaten kay�tl�.");
			return false;
		}
		return true;
		
	}
}
