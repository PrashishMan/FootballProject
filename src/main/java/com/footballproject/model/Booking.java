package com.footballproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingId")
	public int bookingId;
	
	@Column(name = "date")
	public Date date;
	
	@Column(name = "pitchNo")
	public int pitchNo;
	
	@Column(name = "bookingTime")
	public String bookingTime;
	
	@JoinColumn
	@ManyToOne
	public Branch branchId;
	
	@JoinColumn
	@ManyToOne
	public Team teamName;
	
	public Booking(int bookingId, Date date, int pitchNo, Branch branchId, Team teamName, String bookingTime) {
		this.bookingId = bookingId;
		this.date = date;
		this.pitchNo = pitchNo;
		this.branchId = branchId;
		this.teamName = teamName;
		this.bookingTime = bookingTime;
	}
	
	public Booking() {
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPitchNo() {
		return pitchNo;
	}

	public void setPitchNo(int pitchNo) {
		this.pitchNo = pitchNo;
	}

	public Branch getBranchId() {
		return branchId;
	}

	public void setBranchId(Branch branchId) {
		this.branchId = branchId;
	}

	public Team getTeamName() {
		return teamName;
	}

	public void setTeamName(Team teamName) {
		this.teamName = teamName;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	
	

}
