package com.employee.managment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.managment.dao.EmployeeDao;
import com.employee.managment.dto.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao eDAO;

	public List<Employee> findAll() {
		return eDAO.findAll();
	}
	

	public Employee findById( int id) {
		return eDAO.findById(id);
	}
	

	public String deleteById(int id) {
		return eDAO.deleteById(id)+" Employee(s) delete from the database";
	}
	

	public String save(Employee e) {
		return eDAO.save(e)+" Employee(s) saved successfully";
	}
	

	public String update(Employee e ,int id) {
		return eDAO.update(e, id)+" Employee(s) updated successfully";
	}

}
