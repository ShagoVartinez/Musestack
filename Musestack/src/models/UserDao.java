package models;

import java.util.ArrayList;

public class UserDao{
	
	private ArrayList<User> usersList;
	
	public User createUser(int id, String name, String email, int phone, String password, ArrayList<Genre> interestGenres) {
		return new User(id, name, email, phone, password, interestGenres);
	}
	
	public void addUser(User user) {
		usersList.add(user);
	}	
	
	public ArrayList<User> getUsersList() {
		return usersList;
	}
	
	//add user reports

}
