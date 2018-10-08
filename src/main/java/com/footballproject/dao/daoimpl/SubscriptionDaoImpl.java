package com.footballproject.dao.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footballproject.dao.SubscriptionDao;
import com.footballproject.model.Subscription;

@Repository("subscriptionDao")
public class SubscriptionDaoImpl implements SubscriptionDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addSubscription(Subscription subscription) {
		getSession().saveOrUpdate(subscription);
		
	}

	@Override
	public Subscription getSubscription(int subscriptionId) {
		return getSession().get(Subscription.class, subscriptionId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subscription> getSubscription() {
		return (List<Subscription>)getSession().createCriteria(Subscription.class).list();
	}
	
	@Override
	public int getSubscription(String membershipType, String memberType) {
		Query query = getSession().createQuery("Select price FROM Subscription WHERE memberShipType = ? AND memberType = ?");
		query.setParameter(0, membershipType);
		query.setParameter(1, memberType);
		
		int subscriptionAmount = 0;
		
		if(query.uniqueResult() != null) {
		subscriptionAmount = (Integer)query.uniqueResult();
		}
		
		return subscriptionAmount;
	}
	
	@Override
	public int getSubscriptionId(String membershipType, String memberType) {
		Query query = getSession().createQuery("Select subscriptionId FROM Subscription WHERE memberShipType = ? AND memberType = ?");
		query.setParameter(0, membershipType);
		query.setParameter(1, memberType);
		
		int subscriptionId = 0;
		
		if(query != null) {
			subscriptionId = (Integer)query.uniqueResult();
		}
		
		return subscriptionId;
	}
	

}
