package com.footballproject.dao;

import java.util.List;

import com.footballproject.model.Staff;

public interface StaffDao {
	public void addStaff(Staff staff);
	public Staff getStaff(String userId);
	public List<Staff> getStaff();
	public int getStaffCount();
}
