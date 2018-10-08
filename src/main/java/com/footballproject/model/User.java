package com.footballproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
@MappedSuperclass
public class User implements Serializable {
	
	private static final long serialVersionUID = -832801850827598989L;

	@Id
	@Column(name = "userId")
	public String userId;
	
	@Column(name = "password")
	public String password;
	
	@Column(name = "firstName")
	public String firstName;

	@Column(name = "lastName")
	public String lastName;
	
	@Column(name = "dateOfBirth")
	public Date dateOfBirth;
	
	@Column(name = "gender")
	public String gender;
	
	@Column(name = "email")
	public String email;
	
	@Column(name = "city")
	public String city;
	
	@Column(name = "street")
	public String street;
	
	@Column(name = "post")
	public int post;
	
	public User(String userId, String password, String firstName, String lastName, Date dateOfBirth, String gender, String email,
			String city, String street, int post) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.city = city;
		this.street = street;
		this.post = post;
	}

	public User() {}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
		
}
