package com.gl.emra.service;

import java.util.Set;

import com.gl.emra.entity.User;

public interface UserService {

	public User AddUser(User user);

	public Set<User> fetchAllUsers();

	public User fetchById(long userId);

	public void deleteById(long userId);
}
