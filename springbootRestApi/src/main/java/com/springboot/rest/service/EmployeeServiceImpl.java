package com.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.entity.Employee;
import com.springboot.rest.repository.EmployeeRepository;



@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return repository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer id) {

		Optional<Employee> optional = repository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee not found for id:: " + id);
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {

		Employee existingEmployee = repository.findById(employee.getId()).get();

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		repository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		repository.findById(id);
		repository.deleteById(id);
	}

}
