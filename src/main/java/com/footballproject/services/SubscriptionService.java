package com.footballproject.services;

import java.util.List;

import com.footballproject.model.Subscription;

public interface SubscriptionService {
	public void addSubscription(Subscription subscription);
	public Subscription getSubscription(int subscriptionId);
	public List<Subscription> getSubscription();
	public int getSubscription(String membershipType, String memberType);
	public int getSubscriptionId(String membershipType, String memberType);
}
