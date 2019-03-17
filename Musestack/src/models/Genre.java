package models;

public enum Genre {
	ABSTRACCIONISMO("Abstraccionismo"),
	CUBISMO("Cubismo"),
	EXPRESIONISMO("Expresionismo"),
	FAUVISMO("Fauvismo"),
	IMPRESIONISMO("Impresionismo"),
	SURREALISMO("Surrealismo");
	
	private String text;
	
	private Genre(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}

}
