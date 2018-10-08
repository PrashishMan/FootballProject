package com.footballproject.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.footballproject.dao.StaffDao;
import com.footballproject.model.Staff;
import com.footballproject.services.StaffService;

@Service("staffService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StaffServiceImpl implements StaffService{

	@Autowired
	StaffDao staffDao;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void addStaff(Staff staff) {
		staffDao.addStaff(staff);
	}

	@Override
	public Staff getStaff(String userId) {
		return staffDao.getStaff(userId);
	}

	@Override
	public List<Staff> getStaff() {
		return staffDao.getStaff();
	}

	@Override
	public int getStaffCount() {
		// TODO Auto-generated method stub
		return staffDao.getStaffCount();
	}

}
