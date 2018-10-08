package com.footballproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.footballproject.services.MemberService;
import com.footballproject.services.SubscriptionService;

@Entity
@Table(name = "subscriptionPayment")
public class SubscriptionPayment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4015123679839470820L;

	@Transient
	SubscriptionService subscritptionService;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paymentId")
	public int paymentId;

	@JoinColumn
	@ManyToOne
	public Member memberId;

	@JoinColumn
	@ManyToOne
	public Subscription subscriptionId;
	
	@Column(name = "subscriptionDate")
	public Date subscriptionDate;

	public SubscriptionPayment() {
	}

	public SubscriptionPayment(Member memberId, Subscription subscriptionId) {
		super();
		this.subscriptionDate = new Date();
		this.memberId = memberId;
		this.subscriptionId = subscriptionId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Member getMemberId() {
		return memberId;
	}

	public void setMemberId(Member memberId) {
		this.memberId = memberId;
	}

	public Subscription getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Subscription subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	

	
}
