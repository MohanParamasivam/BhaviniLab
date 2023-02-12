package com.gl.emra.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface DomainUserDetailsService {
	
	public UserDetails loadUserByUserName(String userName);

}
