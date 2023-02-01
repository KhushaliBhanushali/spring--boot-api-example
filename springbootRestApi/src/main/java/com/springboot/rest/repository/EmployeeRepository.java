package com.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
