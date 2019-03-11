package models;

public class Admin extends Person{

	private String password;
	
	public Admin(int id, String name, String email, int phone, String password) {
		super(id, name, email, phone);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

}
