package com.axis.service;

import java.util.List;

import com.axis.entity.Employee;

public interface EmployeeService {

	
	Employee addEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(int id);
	Employee updateEmployeeById(int id , Employee employee);
	String deleteEmployeeById(int id );
	

}
