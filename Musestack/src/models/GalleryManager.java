package models;

import java.util.ArrayList;

public class GalleryManager {
	
	private ArrayList<Gallery> galleryList;

	public GalleryManager() {
		galleryList = new ArrayList<>();
	}
	
	public static Gallery createGallery(String name, String city, String address,
			String phone, boolean availability){
		return new Gallery(name, city, address, phone, availability);
	}
	
	public void addGallery(Gallery gallery) {
		galleryList.add(gallery);
	}
	
	public ArrayList<Gallery> getGalleryList() {
		return galleryList;
	}
	
	public ArrayList<Gallery> findByAvailability() {
		ArrayList<Gallery> foundGalleries = new ArrayList<Gallery>();
		
		for (Gallery gallery : galleryList) {
			if(gallery.isAvailable()) {
				foundGalleries.add(gallery);
			}
		}
		
		return foundGalleries;
	}
	
	public ArrayList<Object[]> createObjectForTable() {
		ArrayList<Object[]> objectList = new ArrayList<>();
		for (int i = 0; i < galleryList.size(); i++) {
			objectList.add(new Object[] {galleryList.get(i).getName(), 
					galleryList.get(i).getCity(), 
					galleryList.get(i).getAddress(),
					galleryList.get(i).getPhone(), 
					galleryList.get(i).isAvailable()});
		}
		return objectList;
	}
}