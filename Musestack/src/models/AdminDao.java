package models;

import java.util.ArrayList;

public class AdminDao {
	
	private ArrayList<Admin> adminsList;
	
	public Admin createAdmin(int id, String name, String email, int phone, String password) {
		return new Admin(id, name, email, phone, password);
	}
	
	public void addAdmin(Admin admin) {
		adminsList.add(admin);
	}
	
	public ArrayList<Admin> getAdminsList() {
		return adminsList;
	}
	
	//add admin reports

}
