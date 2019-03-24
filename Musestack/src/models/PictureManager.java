package models;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class PictureManager {
	
	private ArrayList<Picture> pictureList;
	
	public PictureManager() {
		pictureList = new ArrayList<>();
	}
	
	public Picture createPicture(int id, String name, String image, Artist author, 
			Dimension size, short year, Genre genre, boolean state, ArrayList<Byte> scoresList){
		return new Picture(id, name, image, author, size, year, genre, state, scoresList);
	}
	
	
	public void addPicture(Picture picture) {
		pictureList.add(picture);
	}
	
	public ArrayList<Picture> getPictureList() {
		return pictureList;
	}
	
	public ArrayList<Picture> getPicturesByName(String name) {
		ArrayList<Picture> namedPictures = new ArrayList<Picture>();
		
		for (Picture picture : namedPictures) {
			if(picture.getName().equals(name)) {
				namedPictures.add(picture);
			}			
		}
		
		return namedPictures;
	}
	
	public ArrayList<Picture> findByAuthor(Artist author){
		ArrayList<Picture> foundPictures = new ArrayList<Picture>();
		
		for (Picture picture : pictureList) {
			if(picture.getAuthor() == author) {
				foundPictures.add(picture);
			}
		}
		
		return foundPictures;
	}
	
	
	public ArrayList<Picture> findByGenre(Genre genre) {
		ArrayList<Picture> foundPictures = new ArrayList<Picture>();
		
		for (Picture picture : foundPictures) {
			if(picture.getGenre() == genre) {
				
			}
		}
		
		return foundPictures;
	}
	
	
	
	public ArrayList<Picture> findBestScorePictures(){
		ArrayList<Picture> bestScorePictures = new ArrayList<Picture>();
		
		Collections.sort(pictureList, new Comparator<Picture>() {
			public int compare(Picture p1, Picture p2) {
				return new Double(p1.getPromScore()).compareTo(p2.getPromScore());
			}
		});
		//Collections sorts from smaller to greater by default, so gotta reverse the arrayList
		
		Collections.reverse(pictureList);
		
		for (int i = 0 ; i < 5 ; i++) {
			bestScorePictures.add(pictureList.get(i));
		}
		
		return bestScorePictures;		
	}
	
	public ArrayList<Picture> avaliablePicturesByGenre(Genre genre) {
		ArrayList<Picture> availableByGenre = new ArrayList<Picture>();
		
		for (Picture picture : pictureList) {
			if(picture.isState() && picture.getGenre() == genre) {
				availableByGenre.add(picture);
			}
		}
		
		return availableByGenre;
	}
	
	
	public ArrayList<Object[]> createObjectForTable() {
		ArrayList<Object[]> objectList = new ArrayList<>();
		for (int i = 0; i < pictureList.size(); i++) {
			objectList.add(new Object[] {
					pictureList.get(i).getId(),
					pictureList.get(i).getName(), 
					pictureList.get(i).getImage(), 
					pictureList.get(i).getAuthor(),
					pictureList.get(i).getSize(), 
					pictureList.get(i).getYear(),
					pictureList.get(i).getGenre(),
					pictureList.get(i).isState(),
					//get the picture's final Score
					pictureList.get(i).getPromScore()
					});
		}
		return objectList;
	}

	private void setUnsortedPictureList()
    {
        ArrayList<Picture> testList = new ArrayList<>();
        Random rand = new Random(5);
         
        for(int i = 0; i < 10; i++)
        {
        	Picture e = new Picture(rand.nextInt(1000), null, null, null, null, (short)0, null, false, null);
            e.setPromScore(Double(rand.nextInt(5)));
            testList.add(e);
        }
        pictureList = testList;
    }
	
	private static double Double(int nextInt) {
		// TODO Auto-generated method stub
		return 0;
	}

	//TESTS METHOD
	public static void main(String[] args) {
		PictureManager picMng = new PictureManager();
		picMng.setUnsortedPictureList();		
		
		System.out.println(picMng.findBestScorePictures());
	}
}