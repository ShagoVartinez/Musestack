package models;

import java.util.ArrayList;

public class User extends Person{
	
	private ArrayList<Genre> interestGenres;
	private String password;

	public User(int id, String name, String email, int phone, String password, ArrayList<Genre> interestGenres) {
		super(id, name, email, phone);
		this.password = password;
	}

	public ArrayList<Genre> getInterestGenres() {
		return interestGenres;
	}
	
	public String getPassword() {
		return password;
	}

}