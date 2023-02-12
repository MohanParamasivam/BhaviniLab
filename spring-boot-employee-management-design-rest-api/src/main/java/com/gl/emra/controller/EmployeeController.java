package com.gl.emra.controller;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.emra.entity.Employee;
import com.gl.emra.entity.Role;
import com.gl.emra.entity.User;
import com.gl.emra.service.EmployeeService;
import com.gl.emra.service.RoleService;
import com.gl.emra.service.UserService;
import com.gl.emra.serviceImpl.EmployeeServiceImpl;
import com.gl.emra.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	private RoleService roleService;
	private UserService userService;

	public EmployeeController(EmployeeServiceImpl employeeService, UserServiceImpl userService) {
		this.employeeService = employeeService;
		this.userService = userService;
	}

	@GetMapping("/getAllEmployees")
	public Set<Employee> fetchAllemployees() {
		return this.employeeService.fetchAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee fetchById(@PathVariable("id") long employeeId) {
		return this.employeeService.fetchById(employeeId);
	}

	@PostMapping("/setEmployee")
	public Employee save(@RequestBody Employee employee) {
		return this.employeeService.AddEmployee(employee);
	}

	@PostMapping("/setRoles")
	public Role save(@RequestBody Role role) {
		System.out.println(role);
		return this.roleService.AddRole(role);
	}

	@PostMapping("/setUser")
	public User save(@RequestBody User user) {
		return this.userService.AddUser(user);
	}

	@GetMapping("/fetchRoles")
	public Set<Role> fetchAllroles() {
		return this.roleService.fetchAllRoles();
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") long employeeId) {
		this.employeeService.deleteById(employeeId);
		return "Deleted employee id - " + employeeId;
	}

	@Transactional
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee) {
		return this.employeeService.updateEmployee(employeeId, employee);
	}

	@GetMapping("/search/{firstName}")
	public Set<Employee> fetchByFirstName(@PathVariable("firstName") String search) {
		return this.employeeService.FetchByFirstName(search);
	}

	@GetMapping("/sort")
	public List<Employee> fetchAllEmployeesByFirstName(@RequestParam(name = "order", required = true) String order) {
		return this.employeeService.fetchAllEmployeesByFirstName(order);
	}

}

