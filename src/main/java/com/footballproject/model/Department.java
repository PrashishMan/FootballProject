package com.footballproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.footballproject.services.BranchService;
import com.footballproject.services.DepartmentService;

@Entity
@Table (name = "department")
public class Department implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1505804515523638851L;

	
	@Id
	@Column(name = "departmentId")
	public String departmentId;
	
	@ManyToOne
	@JoinColumn(name = "branchId")
	public Branch branchId;
	
	@Column(name = "departmentName")
	public String departmentName;

	public Department() {
	}
	
	

	public Department(String departmentId, Branch branchId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.branchId = branchId;
		this.departmentName = departmentName;
	}



	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Branch getBranchId() {
		return branchId;
	}

	public void setBranchId(Branch branchId) {
		this.branchId = branchId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	

	

}
