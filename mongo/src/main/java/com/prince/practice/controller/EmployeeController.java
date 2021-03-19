package com.prince.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prince.practice.entity.Employee;
import com.prince.practice.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("Hello World");
		return "Hello World";
	}
	
	@GetMapping("/employee")
	public List<Employee> getAll(){
		List<Employee> list = employeeService.getAll();
		return list;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee employee1 = employeeService.addEmployee(employee);
		return employee1;
	}
	
	@PutMapping("/employee")
	public String updateEmployee(@RequestBody Employee employee) {
		String msg = employeeService.updateEmployee(employee);
		return msg;
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		 return employeeService.updateEmployee( id);
	}
	
	
}
