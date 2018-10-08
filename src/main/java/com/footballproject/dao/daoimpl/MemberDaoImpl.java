package com.footballproject.dao.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footballproject.dao.MemberDao;
import com.footballproject.model.Member;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addMember(Member member) {
		getSession().saveOrUpdate(member);
		
	}

	@Override
	public Member getMember(String memberId) {
		return (Member)getSession().get(Member.class, memberId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getMember() {
		return (List<Member>)getSession().createCriteria(Member.class).list();
	}
	
	@Override
	public int getMemberCount() {
		Query query = getSession().createQuery("SELECT count(userId) FROM Member");
		int count = 0;
		if(query.uniqueResult() != null) {
			count = ((Long)query.uniqueResult()).intValue();
		}
		return count;
	}

	@Override
	public List<Member> getNewMember() {
		Query query = getSession().createQuery("FROM Member WHERE state = 0 AND password = NULL");
		@SuppressWarnings("unchecked")
		List<Member> list = (List<Member>)query.list();
		return list;
	}
	
	@Override
	public List<Member> getPaymentDueMember() {
		Query query = getSession().createQuery("FROM Member WHERE subscriptionStatus = 0");
		@SuppressWarnings("unchecked")
		List<Member> list = (List<Member>)query.list();
		return list;
	}

}
