package com.userdbService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "UserAdressDetails")
public class UserAdressDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private Integer id;
	@Column(name="addressline")
	private String addressline;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="pincode")
	private String pincode;
	@Column(name="user_id")
	private Integer userId;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="User_Id") private UserDetails userdetailsId;
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserAdressDetails [id=" + id + ", addressline=" + addressline + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", userId=" + userId + "]";
	}



}
