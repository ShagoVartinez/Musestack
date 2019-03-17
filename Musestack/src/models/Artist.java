package models;

public class Artist extends Person{

	private String address;
	private String email;
	private String password;
	
	public Artist(long id, String photo, String firstName, String lastName, long phone, String city, String address,
			String email, String password) {
		super(id, photo, firstName, lastName, phone, city);
		this.address = address;
		this.email = email;
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "Artist [address: " + address + ", email: " + email + ", password: " + password + "]";
	}
}