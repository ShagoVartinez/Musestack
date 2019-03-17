package models;

public class Gallery {
	
	private String name;
	private String city;
	private String address;
	private long phone;
	private boolean availability;
	
	public Gallery(String name, String city, String address, long phone, boolean availability) {
		this.name = name;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.availability = availability;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public String getAddress() {
		return address;
	}
	public long getPhone() {
		return phone;
	}
	public boolean isAvailability() {
		return availability;
	}
}