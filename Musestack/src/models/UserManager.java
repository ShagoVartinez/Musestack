package models;

import java.util.ArrayList;

public class UserManager {

	private ArrayList<User> userList;
	
	public UserManager() {
		userList = new ArrayList<>();
	}
	
	public User createUser(long id, String photo, String firstName, String lastName, 
			long phone, String city, String email, String password){
		return new User(id, photo, firstName, lastName, phone, city, email, password);
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	
	public ArrayList<User> getUserList() {
		return userList;
	}
	
	public ArrayList<Object[]> createObjectForTable() {
		ArrayList<Object[]> objectList = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			objectList.add(new Object[] {userList.get(i).getId(), 
					userList.get(i).getPhoto(), 
					userList.get(i).getFirstName(),
					userList.get(i).getLastName(), 
					userList.get(i).getPhone(),
					userList.get(i).getCity(),
					userList.get(i).getEmail(),
					userList.get(i).getPassword()});
		}
		return objectList;
	}
}