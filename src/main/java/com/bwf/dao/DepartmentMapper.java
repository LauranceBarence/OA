package com.bwf.dao;

import java.util.List;

import com.bwf.entity.Department;

public interface DepartmentMapper {
	public List<Department>getAllDepartment();
	
	public Department getDepartmentById(Integer id);
}
