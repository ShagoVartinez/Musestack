package models;

import java.util.ArrayList;

public class Artist extends Person{

	private String address;
	private String email;
	private String password;
	private ArrayList<Genre> genres;
	private double score;
	
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
	
	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}
	
	public ArrayList<Genre> getGenres() {
		return genres;
	}
	
	@Override
	public String toString() {
		return "Artist [address: " + address + ", email: " + email + ", password: " + password +  ", " + "]";
	}

	public void setScore(double artistAverageScore) {
		score = (double)((int)((artistAverageScore * 100))) / 100;		
	}
	
	public double getScore() {
		return score;
	}
}