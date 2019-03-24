package models;

import java.util.ArrayList;

public class CritiqueManager {
	
	private ArrayList<Critique> critiquesList;
	
	public CritiqueManager() {
		this.critiquesList = new ArrayList<>();
	}
	
	public Critique createCritique(int pictureId, int critiqueAuthorId, String comment) {
		Critique newCritique = null; 

		if(checkAuthor(pictureId, critiqueAuthorId)) {
			newCritique = new Critique(pictureId, critiqueAuthorId, comment);
		}else {
			System.err.println("the user has already given a critique about this artwork"
					+ "\n (there can be just a critique about one artwork by every user)");
		}
		
		return newCritique;
	}
	
	//METHOD TO SELECT CRITIQUES BY PCTURE_ID
	public ArrayList<Critique> findCritiquesByPicId(int pictureId){
		ArrayList<Critique> foundPicCritiques = new ArrayList<>();
		
		for (Critique critique : critiquesList) {
			if(pictureId == critique.getPictureId()) {
				foundPicCritiques.add(critique);
			}
		}
		
		return foundPicCritiques;
	}
	
	//METHOD TO SELECT CRITIQUES BY USER_ID
	public ArrayList<Critique> findCritiquesByUserId(int userId){
		ArrayList<Critique> foundUserCritiques = new ArrayList<>();
		
		for (Critique critique : critiquesList) {
			if(userId == critique.getCritiqueAuthorId()) {
				foundUserCritiques.add(critique);
			}
		}
		
		return foundUserCritiques;
	}
	
	
		
	public boolean checkAuthor(int pictureId, int critiqueAuthorId) {
		boolean checkedAuthorId = true;
		for (Critique critique : getCritiques()) {
			if(critiqueAuthorId == critique.getCritiqueAuthorId() && pictureId == critique.getPictureId()) {
				checkedAuthorId = false;
			}
		}
		
		return checkedAuthorId;
	}
	
	public ArrayList<Critique> getCritiques() {
		return critiquesList;
	}

}
