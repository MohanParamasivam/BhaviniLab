package com.gl.emra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.emra.entity.Employee;
import com.gl.emra.entity.Role;
import com.gl.emra.entity.User;
import com.gl.emra.repository.EmployeeRepository;
import com.gl.emra.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {
	
	private final EmployeeRepository employeeRepository;
	private final UserRepository userRepository;

//	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertEmployees(ApplicationReadyEvent event) {
		Employee Anil = new Employee();
		Anil.setFirstName("Anil");
		Anil.setLastName("Jain");
		Anil.setEmail("AnilJain@gmail.com");
		this.employeeRepository.save(Anil);
		
		Employee Sunil = new Employee();
		Sunil.setFirstName("Sunil");
		Sunil.setLastName("Sharma");
		Sunil.setEmail("SunilSharma@gmail.com");
		this.employeeRepository.save(Sunil);

		User user = new User();
		user.setUserName("user");
		user.setPassword(passwordEncoder.encode("user"));
		
		Role userRole = new Role();
		userRole.setRoleName("USER");
		userRole.setUsers(user);
		user.addRole(userRole);

		User Admin = new User();
		Admin.setUserName("Admin");
		Admin.setPassword(passwordEncoder.encode("admin"));
		
		Role AdminRole = new Role();
		AdminRole.setRoleName("ADMIN");
		AdminRole.setUsers(Admin);
		Admin.addRole(AdminRole);

		this.userRepository.save(user);
		this.userRepository.save(Admin);
	}
}
