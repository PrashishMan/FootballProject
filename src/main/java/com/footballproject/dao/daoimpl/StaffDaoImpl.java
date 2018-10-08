package com.footballproject.dao.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footballproject.dao.StaffDao;
import com.footballproject.model.Staff;

@Repository("staffDao")
public class StaffDaoImpl implements StaffDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addStaff(Staff staff) {
		getSession().saveOrUpdate(staff);
		
	}

	@Override
	public Staff getStaff(String userId) {
		return (Staff)getSession().get(Staff.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> getStaff() {
		return (List<Staff>)getSession().createCriteria(Staff.class).list();
	}
	
	@Override
	public int getStaffCount() {
		Query query = getSession().createQuery("SELECT count(userId) FROM Staff");
		int count = 0;
		if(query.uniqueResult() != null) {
			count = ((Long)query.uniqueResult()).intValue();
		}
		return count;
	}
	

}
