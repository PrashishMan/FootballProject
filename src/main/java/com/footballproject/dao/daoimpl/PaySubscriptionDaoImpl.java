package com.footballproject.dao.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footballproject.dao.PaySubscriptionDao;
import com.footballproject.model.SubscriptionPayment;

@Repository("paySubscriptionDao")
public class PaySubscriptionDaoImpl implements PaySubscriptionDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addSubscriptionPayment(SubscriptionPayment subscriptionPayment) {
		getSession().saveOrUpdate(subscriptionPayment);
		
	}

	@Override
	public SubscriptionPayment getSubscriptionPayment(String member, Date paymentDate) {
		return (SubscriptionPayment) getSession().get(member, paymentDate);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubscriptionPayment> getSubscriptionPayment() {
		return (List<SubscriptionPayment>) getSession().createCriteria(SubscriptionPayment.class).list();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<SubscriptionPayment> getClearedSubscriber(){
		int year = new Date().getYear()-1;
		Date actualDate = new Date();
		actualDate.setYear(year);
		Query query = getSession().createQuery("FROM SubscriptionPayment WHERE subscriptionDate > ? ");
		query.setParameter(0, actualDate);
		return (List<SubscriptionPayment>)query.list();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<SubscriptionPayment> getDueTrialSubscriber(){
		int year = new Date().getYear()-1;
		int month = new Date().getMonth()-1;	
		
		Date monthLateDate = new Date();
		Date actualDate = new Date();
		
		actualDate.setYear(year);
		monthLateDate.setYear(year);
		monthLateDate.setMonth(month);
		
		
		Query query = getSession().createQuery("FROM SubscriptionPayment WHERE subscriptionDate > ? AND subscriptionDate < ?");
		query.setParameter(0, monthLateDate);
		query.setParameter(1, actualDate);
		List<SubscriptionPayment> dueSubscriptionList = (List<SubscriptionPayment>)query.list();
		
		return dueSubscriptionList;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<SubscriptionPayment> getUnpaidSubscriber(){
		int year = new Date().getYear()-1;
		int month = new Date().getMonth()-1;	
		int exceedYear = new Date().getYear()-2;
		
		Date monthLateDate = new Date();
		Date exceedDate = new Date();
		
		exceedDate.setYear(exceedYear);
		monthLateDate.setYear(year);
		monthLateDate.setMonth(month);
		
		
		Query query = getSession().createQuery("FROM SubscriptionPayment WHERE subscriptionDate > ? AND subscriptionDate < ?");
		query.setParameter(0, exceedDate);
		query.setParameter(1, monthLateDate);
		List<SubscriptionPayment> dueSubscriptionList = (List<SubscriptionPayment>)query.list();
		List<SubscriptionPayment> paymentList = new ArrayList<>();

		return dueSubscriptionList;
	}

}
