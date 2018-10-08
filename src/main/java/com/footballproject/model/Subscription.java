package com.footballproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subscription")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subscriptionId")
	public int subscriptionId;

	@Column(name = "memberShipType")
	public String memberShipType;

	@Column(name = "memberType")
	public String memberType;

	@Column(name = "price")
	public int price;

	public Subscription() {
	}

	public Subscription(int subscriptionId, String memberShipType, String memberType, int price) {
		this.subscriptionId = subscriptionId;
		this.memberShipType = memberShipType;
		this.memberType = memberType;
		this.price = price;
	}
	
	public Subscription(String memberShipType, String memberType, int price) {
		this.memberShipType = memberShipType;
		this.memberType = memberType;
		this.price = price;
	}

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getMemberShipType() {
		return memberShipType;
	}

	public void setMemberShipType(String memberShipType) {
		this.memberShipType = memberShipType;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
