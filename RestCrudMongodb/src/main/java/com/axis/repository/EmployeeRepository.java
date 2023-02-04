package com.axis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.axis.entity.Employee;



public interface EmployeeRepository extends MongoRepository<Employee, Integer>{
	

}
