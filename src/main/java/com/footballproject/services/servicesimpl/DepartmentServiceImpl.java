package com.footballproject.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.footballproject.dao.DepartmentDao;
import com.footballproject.model.Department;
import com.footballproject.services.DepartmentService;

@Service("departmentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentDao departmentDao;
	
	@Override
	@Transactional(readOnly = false)
	public void addDepartment(Department department) {
		departmentDao.addDepartment(department);
	}

	@Override
	public Department getDepartment(String departmentId) {
		return departmentDao.getDepartment(departmentId);
	}

	@Override
	public List<Department> getDepartment() {
		return departmentDao.getDepartment();
	}

	@Override
	public int getDepartmentCount() {
		return departmentDao.getDepartmentCount();
	}

}
