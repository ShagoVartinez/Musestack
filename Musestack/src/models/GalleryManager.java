package models;

import java.util.ArrayList;

public class GalleryManager {
	
	private ArrayList<Gallery> galleryList;

	public GalleryManager() {
		galleryList = new ArrayList<>();
	}
	
	public Gallery createGallery(String name, String city, String address, 
			long phone, boolean availability){
		return new Gallery(name, city, address, phone, availability);
	}
	
	public void addGallery(Gallery gallery) {
		galleryList.add(gallery);
	}
	
	public ArrayList<Gallery> getGalleryList() {
		return galleryList;
	}
	
	public ArrayList<Object[]> createObjectForTable() {
		ArrayList<Object[]> objectList = new ArrayList<>();
		for (int i = 0; i < galleryList.size(); i++) {
			objectList.add(new Object[] {galleryList.get(i).getName(), 
					galleryList.get(i).getCity(), 
					galleryList.get(i).getAddress(),
					galleryList.get(i).getPhone(), 
					galleryList.get(i).isAvailability()});
		}
		return objectList;
	}
}