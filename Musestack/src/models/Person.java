package models;

public abstract class  Person{
	
	int id;
	String name;
	String email;
	
	public Person(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
}
