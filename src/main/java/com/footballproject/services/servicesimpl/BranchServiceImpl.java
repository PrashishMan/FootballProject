package com.footballproject.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.footballproject.dao.BranchDao;
import com.footballproject.model.Branch;
import com.footballproject.services.BranchService;

@Service("branchService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BranchServiceImpl implements BranchService{

	@Autowired
	BranchDao branchDao;
	
	@Override
	@Transactional(readOnly = false)
	public void addBranch(Branch branch) {
		branchDao.addBranch(branch);
		
	}

	@Override
	public Branch getBranch(String branchId) {
		return branchDao.getBranch(branchId);
	}

	@Override
	public List<Branch> getBranch() {
		return branchDao.getBranch();
	}
	
	@Override
	public Branch getHeadBranch() {
		return branchDao.getHeadBranch();
	}

	@Override
	public int getBranchCount() {
		return branchDao.getBranchCount();
	}
	
}
