package com.gl.emra.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.emra.entity.Employee;
import com.gl.emra.repository.EmployeeRepository;
import com.gl.emra.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired 
	private final EmployeeRepository employeeRepository;

	public void addEmployee (Employee employee) {
		employeeRepository.saveAndFlush(employee);
	}
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee AddEmployee(Employee employee) {
		Employee savedEmployee = this.employeeRepository.save(employee);
		return savedEmployee;
	}

	public Set<Employee> fetchAllEmployees() {
		return new HashSet<>(this.employeeRepository.findAll());
	}

	public Employee fetchById(long employeeId) {
		return this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid employee id"));
	}

	public void deleteById(long employeeId) {
		this.employeeRepository.deleteById(employeeId);
	}

	public Employee updateEmployee(long employeeId, Employee updatedEmployee) {
		System.out.println("Passed in employee is " + updatedEmployee);
		System.out.println("Passed employee-id is :: " + employeeId);
		Employee employeeFromRepository = this.fetchById(employeeId);
		employeeFromRepository.setFirstName(updatedEmployee.getFirstName());
		employeeFromRepository.setLastName(updatedEmployee.getLastName());
		employeeFromRepository.setEmail(updatedEmployee.getEmail());
		this.employeeRepository.save(employeeFromRepository);
		return employeeFromRepository;

	}

	public Set<Employee> FetchByFirstName(String firstName) {
		return new HashSet<>(this.employeeRepository.findEmployeeByFirstName(firstName));

	}

	public List<Employee> fetchAllEmployeesByFirstName(String order) {

		if (order.equalsIgnoreCase("asc"))
			return new ArrayList<>(this.employeeRepository.findAllByOrderByFirstNameAsc());
		else if (order.equalsIgnoreCase("desc"))
			return new ArrayList<>(this.employeeRepository.findAllByOrderByFirstNameDesc());
		else
			return null;
	}
}
