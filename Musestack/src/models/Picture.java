package models;

import java.awt.Dimension;
import java.util.ArrayList;

public class Picture{

	private int id;
	private String name;
	private String image;
	private Artist author;
	private Dimension size;
	private short year;
	private Genre genre;
	private boolean state;
	private ArrayList<Byte> scoresList;
	private double promScore;
	
	public Picture(int id, String name, String image, Artist author,
			Dimension size, short year, Genre genre, boolean state, ArrayList<Byte> scoresList) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.author = author;
		this.size = size;
		this.year = year;
		this.genre = genre;
		this.state = state;
		this.scoresList = scoresList;
	}
	
	public int getId() {
		return id;
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

	public void addScore(String value) {
		scoresList.add((byte)Integer.parseInt(value));
	}

	public ArrayList<Byte> getScoresList() {
		return scoresList;
	}
	
	public void calcPromScore() {
		double thisPictureScore = 0;
		double scoreCount = 0;
		
		if(scoresList != null) {
		for (int i = 0; i < scoresList.size(); i++) {
			scoreCount = scoreCount + (double) scoresList.get(i);
		}
		
		promScore = scoreCount / (double)scoresList.size();
		//this operation allows just two decimals double
		promScore = (double)((int)((thisPictureScore * 100))) / 100;
		}else {
			promScore = 0;
		}
	}
	
	public void setPromScore(double promScore) {
		this.promScore = promScore;
	}
	
	public double getPromScore() {
		calcPromScore();
		return promScore;
	}
	

//	public ArrayList<String> getCritique() {
//		return critique;
//	}
	
	

	@Override
	public String toString() {
		return "Picture [id: " + id + ", name: " + name + ", image:" + image 
				+ ", author: " + author + ", size: " + size + ", year: " + year
				+ ", genre: " + genre + ", state: " + state + "]";
	}



//TESTS METHOD
//public static void main(String[] args) {
//	PictureManager PicMng = new PictureManager();
//	ArrayList<Byte> testByteList = new ArrayList<Byte>();
//	
//	testByteList.add((byte)3);
//	testByteList.add((byte)3);
//	testByteList.add((byte)5);
//	
//	System.out.println();
//}

}