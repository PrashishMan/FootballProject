package com.footballproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
	@Id
	@Column(name = "teamName")
	public String teamName;
	
	@Column(name = "registrationDate")
	public Date registrationDate; 
	
	@JoinColumn
	@OneToOne
	public Member teamOrganizer;
	
	public Team(String teamName, Member teamOrganizer) {
		this.teamName = teamName;
		this.teamOrganizer = teamOrganizer;
		registrationDate = new Date();
	}
	
	public Team() {
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Member getTeamOrganizer() {
		return teamOrganizer;
	}

	public void setTeamOrganizer(Member teamOrganizer) {
		this.teamOrganizer = teamOrganizer;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
	
}
