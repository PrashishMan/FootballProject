package com.footballproject.services.servicesimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.footballproject.dao.PaySubscriptionDao;
import com.footballproject.model.SubscriptionPayment;
import com.footballproject.services.PaySubscriptionService;

@Service("paySubscriptionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PaySubscriptionServiceImpl implements PaySubscriptionService{
	
	@Autowired
	PaySubscriptionDao paySubscriptionDao;
	
	@Transactional(readOnly = false)
	public void addSubscriptionPayment(SubscriptionPayment subscriptionPayment) {
		paySubscriptionDao.addSubscriptionPayment(subscriptionPayment);
	}
	public SubscriptionPayment getSubscriptionPayment(String member, Date paymentDate) {
		return paySubscriptionDao.getSubscriptionPayment(member, paymentDate);
	}
	public List<SubscriptionPayment> getSubscriptionPayment(){
		return (List<SubscriptionPayment>)paySubscriptionDao.getSubscriptionPayment();	
	}
	@Override
	public List<SubscriptionPayment> getClearedSubscriber() {
		// TODO Auto-generated method stub
		return (List<SubscriptionPayment>)paySubscriptionDao.getClearedSubscriber();
	}
	@Override
	public List<SubscriptionPayment> getDueTrialSubscriber() {
		// TODO Auto-generated method stub
		return (List<SubscriptionPayment>)paySubscriptionDao.getDueTrialSubscriber();
	}
	@Override
	public List<SubscriptionPayment> getUnpaidSubscriber() {
		// TODO Auto-generated method stub
		return (List<SubscriptionPayment>)paySubscriptionDao.getUnpaidSubscriber();
	}
	
	
	
}
