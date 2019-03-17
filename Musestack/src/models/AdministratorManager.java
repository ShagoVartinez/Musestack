package models;

import java.util.ArrayList;

public class AdministratorManager {
	
	private ArrayList<Administrator> administratorList;
	
	public AdministratorManager() {
		administratorList = new ArrayList<>();
	}
	
	public Administrator createAdministrator(long id, String photo, String firstName, String lastName, 
			long phone, String city, String email, String password){
		return new Administrator(id, photo, firstName, lastName, phone, city, email, password);
	}
	
	public void addAdministrator(Administrator administrator) {
		administratorList.add(administrator);
	}
	
	public ArrayList<Administrator> getAdministratorList() {
		return administratorList;
	}
	
	public ArrayList<Object[]> createObjectForTable() {
		ArrayList<Object[]> objectList = new ArrayList<>();
		for (int i = 0; i < administratorList.size(); i++) {
			objectList.add(new Object[] {administratorList.get(i).getId(), 
					administratorList.get(i).getPhoto(), 
					administratorList.get(i).getFirstName(),
					administratorList.get(i).getLastName(), 
					administratorList.get(i).getPhone(),
					administratorList.get(i).getCity(),
					administratorList.get(i).getEmail(),
					administratorList.get(i).getPassword()});
		}
		return objectList;
	}
}