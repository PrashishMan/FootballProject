package com.footballproject.services;

import java.util.List;

import com.footballproject.model.Staff;

public interface StaffService {
	public void addStaff(Staff staff);
	public Staff getStaff(String userId);
	public List<Staff> getStaff();
	public int getStaffCount();
}
