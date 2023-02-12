package com.gl.emra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.emra.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findEmployeeByFirstName(String firstName);

	public List<Employee> findAllByOrderByFirstNameAsc();

	public List<Employee> findAllByOrderByFirstNameDesc();

}