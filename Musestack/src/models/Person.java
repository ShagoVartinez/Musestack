package models;

public abstract class  Person{
	
	int id;
	String name;
	String email;
	int phone;
	
	public Person(int id, String name, String email, int phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
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
	
	public int getPhone() {
		return phone;
	}
	
}
