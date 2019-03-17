package models;

import java.awt.Dimension;
import java.util.ArrayList;

public class Picture {

	private String name;
	private String image;
	private Artist author;
	private Dimension size;
	private short year;
	private Genre genre;
	private boolean state;
	private ArrayList<Byte> qualification;
	private ArrayList<String> critique;
	
	public Picture(String name, String image, Artist author, Dimension size, short year, Genre genre, boolean state) {
		super();
		this.name = name;
		this.image = image;
		this.author = author;
		this.size = size;
		this.year = year;
		this.genre = genre;
		this.state = state;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public Artist getAuthor() {
		return author;
	}

	public Dimension getSize() {
		return size;
	}

	public short getYear() {
		return year;
	}

	public Genre getGenre() {
		return genre;
	}

	public ArrayList<Byte> getQualification() {
		return qualification;
	}

	public ArrayList<String> getCritique() {
		return critique;
	}

	@Override
	public String toString() {
		return "Picture [name: " + name + ", image:" + image + ", author: " + author + ", size: " + size + ", year: " + year
				+ ", genre: " + genre + ", state: " + state + "]";
	}
}