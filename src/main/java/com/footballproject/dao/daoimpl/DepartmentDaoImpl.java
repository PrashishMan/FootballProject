package com.footballproject.dao.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footballproject.dao.DepartmentDao;
import com.footballproject.model.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void addDepartment(Department department) {
		getSession().saveOrUpdate(department);
		
	}

	@Override
	public Department getDepartment(String departmentId) {
		return (Department)getSession().get(Department.class,departmentId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartment() {
		return (List<Department>)getSession().createCriteria(Department.class).list();
	}
	
	@Override
	public int getDepartmentCount() {
		Query query = getSession().createQuery("SELECT count(*) FROM Department");
		int count = 0;
		if(query.uniqueResult() != null) {
			count = ((Long)query.uniqueResult()).intValue();
		}
		return count;
	}
	
	
	

}
