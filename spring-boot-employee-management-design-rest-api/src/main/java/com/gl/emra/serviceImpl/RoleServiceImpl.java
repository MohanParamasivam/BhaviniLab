package com.gl.emra.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gl.emra.entity.Role;
import com.gl.emra.repository.RoleRepository;
import com.gl.emra.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private final RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public Role AddRole(Role role) {
		Role savedRole = this.roleRepository.save(role);
		System.out.println(savedRole);
		return savedRole;
	}

	public Set<Role> fetchAllRoles() {
		return new HashSet<>(this.roleRepository.findAll());
	}

	public Role fetchById(long roleId) {
		return this.roleRepository.findById(roleId).orElseThrow(() -> new IllegalArgumentException("Invalid role id"));
	}

	public void deleteById(long roleId) {
		this.roleRepository.deleteById(roleId);
	}

}
