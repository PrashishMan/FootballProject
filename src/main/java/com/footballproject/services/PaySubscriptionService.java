package com.footballproject.services;

import java.util.Date;
import java.util.List;

import com.footballproject.model.SubscriptionPayment;

public interface PaySubscriptionService {
	public void addSubscriptionPayment(SubscriptionPayment subscriptionPayment);
	public SubscriptionPayment getSubscriptionPayment(String member, Date paymentDate);
	public List<SubscriptionPayment> getSubscriptionPayment();
	public List<SubscriptionPayment> getClearedSubscriber();
	public List<SubscriptionPayment> getDueTrialSubscriber();
	public List<SubscriptionPayment> getUnpaidSubscriber();
}
