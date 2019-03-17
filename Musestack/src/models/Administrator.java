package models;

public class Administrator extends Person{

	private String email;
	private String password;

	

	public Administrator(long id, String photo, String firstName, String lastName, long phone, String city, String email,
			String password) {
		super(id, photo, firstName, lastName, phone, city);
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Administrator [email=" + email + ", password=" + password + "]";
	}
}