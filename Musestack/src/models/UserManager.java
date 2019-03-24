package models;

import java.util.ArrayList;

public class UserManager {

	private ArrayList<User> usersList;
	
	public UserManager() {
		usersList = new ArrayList<>();
	}
	
	public User createUser(int id, String photo, String firstName, String lastName, long phone, String city, String email, String password) {	
		return createUser(id, photo, firstName, lastName, phone, city, email, password);
	}
	
	public void addUser(User user) {
		usersList.add(user);
	}
	
	public ArrayList<User> getUsersList() {
		return usersList;
	}
	
	public ArrayList<User> filterUsers(String name, String lastName){ 
		ArrayList<User> foundUser = new ArrayList<>();
		
		for(User user : usersList) {
			if(user.getFirstName().toLowerCase().equals(name.toLowerCase()) && user.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				foundUser.add(user);
			}
		}
		
		return foundUser;
	}
	
	public ArrayList<Object[]> createObjectForTable() {
		ArrayList<Object[]> objectList = new ArrayList<>();
		for (int i = 0; i < usersList.size(); i++) {
			objectList.add(new Object[] {usersList.get(i).getId(), 
					usersList.get(i).getPhoto(), 
					usersList.get(i).getFirstName(),
					usersList.get(i).getLastName(), 
					usersList.get(i).getPhone(),
					usersList.get(i).getCity(),
					usersList.get(i).getEmail(),
					usersList.get(i).getPassword()});
		}
		
		return objectList;
	}
}