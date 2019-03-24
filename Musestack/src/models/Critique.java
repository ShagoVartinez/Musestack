package models;

public class Critique {
	
	private int pictureId;
	private int critiqueAuthorId;
	private String comment;
	
	public Critique(int pictureId, int critiqueAuthorId, String comment) {
		this.pictureId = pictureId;
		this.critiqueAuthorId = critiqueAuthorId;
		this.comment = comment;
	}
	
	public int getPictureId() {
		return pictureId;
	}

	public int getCritiqueAuthorId() {
		return critiqueAuthorId;
	}

	public String getComment() {
		return comment;
	}	

}