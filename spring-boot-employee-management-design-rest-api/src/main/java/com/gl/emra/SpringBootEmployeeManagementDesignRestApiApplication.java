package com.gl.emra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@ComponentScan(basePackages = { "com.gl.emra.*" })
@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class SpringBootEmployeeManagementDesignRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeManagementDesignRestApiApplication.class, args);
	}

}
