package models;

public class Gallery {
	
	private String name;
	private String city;
	private String address;
	private String phone;
	private boolean available;
	
	public Gallery(String name, String city, String address, String phone, boolean availability) {
		this.name = name;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.available = availability;
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
	public String getPhone() {
		return phone;
	}
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
}