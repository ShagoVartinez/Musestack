package models;

public class Artist extends Person{

	private int id;
	private String name;
	private String email;
	private String country;
	private String city;
	private Genre genre;

	public Artist(int id, String name, String email, String country, String city, Genre genre) {
		super(id, name, email);
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.city = city;
		this.genre = genre;
	}
	
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	@Override
	public String toString() {
		return "\n\nname: " + name + "\nid:" + id + "\nemail: " + email + "\ncountry: " + country + "\ncity: " + city + "\ngenre: " + genre.toString();
	}
	
}
