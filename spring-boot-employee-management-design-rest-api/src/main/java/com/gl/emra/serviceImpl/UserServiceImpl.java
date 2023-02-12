package com.gl.emra.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gl.emra.entity.User;
import com.gl.emra.repository.UserRepository;
import com.gl.emra.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User AddUser(User user) {
		User savedUser = this.userRepository.save(user);
		return savedUser;
	}

	public Set<User> fetchAllUsers() {
		return new HashSet<>(this.userRepository.findAll());
	}

	public User fetchById(long userId) {
		return this.userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user id"));
	}

	public void deleteById(long userId) {
		this.userRepository.deleteById(userId);
	}

}
