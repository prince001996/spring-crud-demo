package com.prince.practice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.prince.practice.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
