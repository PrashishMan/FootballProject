package com.footballproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch")
public class Branch implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8889632897468434473L;

	@Id
	@Column(name = "branchId")
	public String branchId;
	
	@Column(name = "branchCity")
	public String branchCity;
	
	@Column(name = "branchStreet")
	public String branchStreet;
	
	@Column (name = "isHeadBranch")
	public Boolean isHeadBranch;
	
	@Column (name = "poBox")
	public String poBox;
	
	@Column (name = "telephone")
	public String telephoneNo;
	
	@Column (name = "faxNo")
	public String faxNo;

	
	public Branch() {
		
	}


	public Branch(String branchId, String branchCity, String branchStreet, Boolean isHeadBranch, String poBox,
			String telephoneNo, String faxNo) {
		super();
		this.branchId = branchId;
		this.branchCity = branchCity;
		this.branchStreet = branchStreet;
		this.isHeadBranch = isHeadBranch;
		this.poBox = poBox;
		this.telephoneNo = telephoneNo;
		this.faxNo = faxNo;
	}


	public String getBranchId() {
		return branchId;
	}


	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}


	public String getBranchCity() {
		return branchCity;
	}


	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}


	public String getBranchStreet() {
		return branchStreet;
	}


	public void setBranchStreet(String branchStreet) {
		this.branchStreet = branchStreet;
	}


	public Boolean getIsHeadBranch() {
		return isHeadBranch;
	}


	public void setIsHeadBranch(Boolean isHeadBranch) {
		this.isHeadBranch = isHeadBranch;
	}


	public String getPoBox() {
		return poBox;
	}


	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}


	public String getTelephoneNo() {
		return telephoneNo;
	}


	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}


	public String getFaxNo() {
		return faxNo;
	}


	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

}
