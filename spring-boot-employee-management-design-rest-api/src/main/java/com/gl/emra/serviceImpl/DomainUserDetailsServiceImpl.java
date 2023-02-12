package com.gl.emra.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.emra.entity.User;
import com.gl.emra.repository.UserRepository;
import com.gl.emra.security.MyUserDetails;
import com.gl.emra.service.DomainUserDetailsService;

@Service
public class DomainUserDetailsServiceImpl implements DomainUserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUserName(String userName) throws UsernameNotFoundException {
		Optional<User> optionalUser = this.userRepository.findByUserName(userName);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			System.out.println(optionalUser.get());
			return new MyUserDetails(user);

		}
		throw new UsernameNotFoundException("bad credentials");
	}

}