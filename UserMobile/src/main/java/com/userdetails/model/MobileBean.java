package com.userdetails.model;

public class MobileBean {
	
	private String name;
	private String mobile;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "MobileBean [name=" + name + ", mobile=" + mobile + ", type=" + type + "]";
	}


}
