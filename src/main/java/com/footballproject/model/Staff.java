package com.footballproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.footballproject.services.UserService;

@Entity
@Table(name = "Staff")
public class Staff extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7668377998918725324L;

	@Transient
	@Autowired
	UserService userServicen;
			
	@Column(name = "hireDate")
	public Date hireDate;
	
	@Column(name = "salary")
	public int salary;
	
	@JoinColumn
	@ManyToOne
	public Department departmentId;

	
	public Staff(String userId, String password, String firstName, String lastName, Date dateOfBirth, String gender, String email, String city,
			String street, Date hireDate, int salary, int post, Department departmentId) {
		super(userId, password, firstName, lastName, dateOfBirth, gender, email, city, street, 1);
		this.hireDate = hireDate;
		this.salary = salary;
		this.departmentId = departmentId;
	}
	
 
	public Staff() {
		// TODO Auto-generated constructor stub
	}


	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Department getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}
	
	


	
	

}
