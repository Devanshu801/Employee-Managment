package com.employee.managment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.managment.dto.Employee;
import com.employee.managment.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping()
	public ResponseEntity<List<Employee>>findAll() {
		List<Employee> emp = employeeService.findAll();
		if(emp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(emp); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		Employee emp = employeeService.findById(id);
		if(emp != null) {
			return ResponseEntity.status(HttpStatus.OK).body(emp);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id){
		String emp = employeeService.deleteById(id);
		if(emp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	
	@PostMapping()
	public ResponseEntity<String> registerEmployee(@RequestBody Employee employee){
		if(employee!=null) {
			String emp = employeeService.save(employee);
			if(!emp.isBlank()) {
				return ResponseEntity.status(HttpStatus.CREATED).body(emp);
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}	
	

	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id") int id ,@RequestBody Employee employee){
		String emp = employeeService.update(employee,id);
		if(!emp.isBlank()) {
			return ResponseEntity.status(HttpStatus.OK).body(emp);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
}
