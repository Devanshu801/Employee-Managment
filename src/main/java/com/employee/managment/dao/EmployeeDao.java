package com.employee.managment.dao;

import java.util.List;

import com.employee.managment.dto.Employee;

public interface EmployeeDao {
	public List<Employee> findAll();

	public Employee findById(int id);

	public int deleteById(int id);

	public int save(Employee e);

	public int update(Employee e, int id);

}
