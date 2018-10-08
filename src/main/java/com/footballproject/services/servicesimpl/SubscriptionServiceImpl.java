package com.footballproject.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.footballproject.dao.SubscriptionDao;
import com.footballproject.model.Subscription;
import com.footballproject.services.SubscriptionService;

@Service("subscriptionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SubscriptionServiceImpl implements SubscriptionService{

	@Autowired
	SubscriptionDao subscriptionDao;
	
	@Override
	@Transactional(readOnly = false)
	public void addSubscription(Subscription subscription) {	
		subscriptionDao.addSubscription(subscription);
	}

	@Override
	public Subscription getSubscription(int subscriptionId) {
		return subscriptionDao.getSubscription(subscriptionId);
	}

	@Override
	public List<Subscription> getSubscription() {
		return subscriptionDao.getSubscription();
	}
	
	@Override
	public int getSubscription(String membershipType, String memberType) {
		return subscriptionDao.getSubscription(membershipType, memberType);
	}

	@Override
	public int getSubscriptionId(String membershipType, String memberType) {
		return subscriptionDao.getSubscriptionId(membershipType, memberType);
	}
}
