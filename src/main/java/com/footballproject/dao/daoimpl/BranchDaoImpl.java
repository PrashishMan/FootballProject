package com.footballproject.dao.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footballproject.dao.BranchDao;
import com.footballproject.model.Branch;

@Repository("branchDao")
public class BranchDaoImpl implements BranchDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addBranch(Branch branch) {
		getSession().saveOrUpdate(branch);
		
	}

	@Override
	public Branch getBranch(String branchId) {
		return (Branch)getSession().get(Branch.class, branchId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Branch> getBranch() {
		return (List<Branch>)getSession().createCriteria(Branch.class).list();
	}
	
	@Override
	public Branch getHeadBranch() {
		Query query = getSession().createQuery("FROM Branch WHERE isHeadBranch = 1");
		Branch branch = (Branch)query.uniqueResult();
		return branch;
	}

	@Override
	public int getBranchCount() {
		Query query = getSession().createQuery("SELECT count(*) FROM Branch");
		int count = 0;
		if(query.uniqueResult() != null) {
			count = ((Long)query.uniqueResult()).intValue();
		}
		return count;
	}
	
	
	
	

}
