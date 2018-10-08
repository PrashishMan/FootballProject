package com.footballproject.dao;

import java.util.List;

import com.footballproject.model.Branch;

public interface BranchDao {
	public void addBranch(Branch branch);
	public Branch getBranch(String branchId);
	public List<Branch> getBranch();
	public Branch getHeadBranch();
	public int getBranchCount();
}
