package models;

public abstract class Person {
	
	private long id;
	private String photo;
	private String firstName;
	private String lastName;
	private long phone;
	private String city;

	public Person(long id, String photo, String firstName, String lastName, long phone, String city) {
		this.id = id;
		this.photo = photo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public String getPhoto() {
		return photo;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public long getPhone() {
		return phone;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Person [id: " + id + ", photo: " + photo + ", firstName: " + firstName + ", lastName: " + lastName
				+ ", phone: " + phone + ", city: " + city + "]";
	}
}