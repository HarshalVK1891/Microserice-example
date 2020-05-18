package com.useradress.model;

public class Addressbean {
	private String name;
	private String addressline;
	private String city;
	private String state;
	private String pincode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddressline() {
		return addressline;
	}
	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Addressbean [name=" + name + ", addressline=" + addressline + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}
	
	
}
