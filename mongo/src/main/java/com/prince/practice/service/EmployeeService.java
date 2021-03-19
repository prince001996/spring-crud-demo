package com.prince.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prince.practice.entity.Employee;
import com.prince.practice.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		return list;
	}

	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee employee1 = employeeRepository.save(employee);
		return employee1;
	}

	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> employee1 = employeeRepository.findById(employee.getId());
		
		if(employee1.isPresent()) {
			employee1.get().setFirstName(employee.getFirstName());
			employee1.get().setLastName(employee.getLastName());
			employee1.get().setEmail(employee.getEmail());
			employeeRepository.save(employee1.get());
			return "Employee Updated!\n The new values are : \n" + employee.toString();
		}
		return "employee doesn't exist, so can't be updated.";
	}

	public String updateEmployee(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee1 = employeeRepository.findById(id);
		
		if(employee1.isPresent()) {
			employeeRepository.delete(employee1.get());
			return "Employee deleted!\n" + "Values were \n" + employee1.get().toString(); 
		}
		
		return "Employee with " + id + " not present, so can't delete it.";
	}

}
