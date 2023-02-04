package com.axis.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.axis.entity.Employee;
import com.axis.exception.IdNotFoundException;
import com.axis.service.EmployeeService;


@RestController
@RequestMapping("/api/v2")
public class EmployeeController2 {

	
	@Autowired
    EmployeeService employeeService;
	
	
    @PostMapping("/employee")
    ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
    return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.OK);
      }
    
   
     @GetMapping("/employee")
     ResponseEntity<List<Employee>> getAllEmployee(){
     return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee() , HttpStatus.OK);
     }


     @GetMapping("/employee/{id}")
     ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
     return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);}
    


    @PutMapping("/employee/{id}")
    ResponseEntity<Employee> updateEmployeeById(@PathVariable int id,@RequestBody Employee employee){
    return new ResponseEntity<Employee>(employeeService.updateEmployeeById(id, employee), HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/employee/{id}")
    ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
    return new ResponseEntity<String>(employeeService.deleteEmployeeById(id), HttpStatus.OK);
    
    }
    
    
    
	

}
