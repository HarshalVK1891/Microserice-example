package com.userdetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="UserMobileDetails")
public class UserMobileDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer id;
	@Column(name = "mobile")
	private String mobile;
	
	@Enumerated(EnumType.STRING) 
	@Column(name = "contacttype")
	private Phonetype type;
	@Column(name = "userId")
	private Integer userId;
	
	
	
	
	public Phonetype getType() {
		return type;
	}
	public void setType(Phonetype type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserMobileDetails [id=" + id + ", mobile=" + mobile + ", type=" + type + ", userId=" + userId + "]";
	}	
	
	
	
	
	
	
	

}
