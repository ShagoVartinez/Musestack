package models;

import java.util.ArrayList;

public class User extends Person{
	
	private ArrayList<Genre> interestGenres;

	public User(int id, String name, String email,  ArrayList<Genre> interestGenres) {
		super(id, name, email);

	}

	public ArrayList<Genre> getInterestGenres() {
		return interestGenres;
	}

	public void setInterestGenres(ArrayList<Genre> interestGenres) {
		this.interestGenres = interestGenres;
	}

}