package models;

import java.awt.Dimension;
import java.util.ArrayList;

public class PictureManager {

private ArrayList<Picture> pictureList;
	
	public PictureManager() {
		pictureList = new ArrayList<>();
	}
	
	public Picture createPicture(String name, String image, Artist author, 
			Dimension size, short year, Genre genre, boolean state){
		return new Picture(name, image, author, size, year, genre, state);
	}
	
	public void addPicture(Picture picture) {
		pictureList.add(picture);
	}
	
	public ArrayList<Picture> getPictureList() {
		return pictureList;
	}
	
	public ArrayList<Object[]> createObjectForTable() {
		ArrayList<Object[]> objectList = new ArrayList<>();
		for (int i = 0; i < pictureList.size(); i++) {
			objectList.add(new Object[] {pictureList.get(i).getName(), 
					pictureList.get(i).getImage(), 
					pictureList.get(i).getAuthor(),
					pictureList.get(i).getSize(), 
					pictureList.get(i).getYear(),
					pictureList.get(i).getGenre(),
					pictureList.get(i).isState()});
		}
		return objectList;
	}
}