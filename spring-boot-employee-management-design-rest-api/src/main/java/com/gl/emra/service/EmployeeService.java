package com.gl.emra.service;

import java.util.List;
import java.util.Set;

import com.gl.emra.entity.Employee;

public interface EmployeeService {

	public Employee AddEmployee(Employee employee);

	public Set<Employee> fetchAllEmployees();

	public Employee fetchById(long employeeId);

	public void deleteById(long employeeId);

	public Employee updateEmployee(long employeeId, Employee updatedEmployee);

	public Set<Employee> FetchByFirstName(String firstName);

	public List<Employee> fetchAllEmployeesByFirstName(String order);
}
