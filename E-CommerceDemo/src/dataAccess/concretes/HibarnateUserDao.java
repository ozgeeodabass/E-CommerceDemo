package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibarnateUserDao implements UserDao {

	private List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Kullanýcý eklendi: " + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public boolean checkIfEmailIsRegistered(User user) {
		for (User i : users) {
			if(i.getEmail() == user.getEmail()) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public List<User> getAll(){
		
		return users;
	}
		
}
