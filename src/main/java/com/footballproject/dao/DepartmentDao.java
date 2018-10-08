package com.footballproject.dao;

import java.util.List;

import com.footballproject.model.Department;

public interface DepartmentDao {
	public void addDepartment(Department department);
	public Department getDepartment(String departmentId);
	public List<Department> getDepartment();
	public int getDepartmentCount();
}
