package com.footballproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.footballproject.services.MemberService;
import com.footballproject.services.UserService;

@Entity
@Table(name = "Member")
public class Member extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1249786396428408110L;

	@Transient
	@Autowired
	UserService userService;
	
	@Transient
	@Autowired
	MemberService memberService;
			
	@Column(name = "memberShipType")
	public String memberShipType;
	
	@Column(name = "isOrganizer")
	public Boolean isOrganizer;
	
	//0: not paid subscription
	//1: subscription due has exceeded 30 days
	//2: has paid all the subscription
	@Column(name = "subscriptionStatus")
	public int subscriptionStatus;
	
	@JoinColumn
	@ManyToOne
	public Team teamName;
	
	@Column(name = "state")
	public int state;
	
	public Member(String userId, String password, String firstName, String lastName, Date dateOfBirth, String gender, String email,
			String city, String street, String memberShipType, Boolean isOrganizer, 
			Team teamName) {
		super(userId, password, firstName, lastName, dateOfBirth, gender, email, city, street, 0);		
		
		this.memberShipType = memberShipType;
		this.isOrganizer = isOrganizer;
		this.teamName = teamName;
		this.state = 0;
		this.subscriptionStatus = 0;
	}

	public Member() {}

	public String getMemberShipType() {
		return memberShipType;
	}

	public void setMemberShipType(String memberShipType) {
		this.memberShipType = memberShipType;
	}

	public Team getTeamName() {
		return teamName;
	}

	public void setTeamName(Team teamName) {
		this.teamName = teamName;
	}

	public Boolean getIsOrganizer() {
		return isOrganizer;
	}

	public void setIsOrganizer(Boolean isOrganizer) {
		this.isOrganizer = isOrganizer;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(int subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}	
	
	
		
}
