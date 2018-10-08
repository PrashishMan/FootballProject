package com.footballproject.services;

import java.util.List;

import com.footballproject.model.Branch;

public interface BranchService {
	public void addBranch(Branch branch);
	public Branch getBranch(String branchId);
	public List<Branch> getBranch();
	public Branch getHeadBranch();
	public int getBranchCount();
}
