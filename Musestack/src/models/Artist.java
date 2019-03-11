package models;

public class Artist extends Person{

	private String password;
	private Genre genre;

	public Artist(int id, String name, String email, int phone, String password, Genre genre) {
		super(id, name, email, phone);
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.genre = genre;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	@Override
	public String toString() {
		return "\n\nname: " + name + "\nid:" + id + "\nemail: " + email + "\nphone: " + phone + "\npassword: " + password + "\ngenre: " + genre;
	}
	
}