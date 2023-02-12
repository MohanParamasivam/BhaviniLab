package com.gl.emra.service;

import java.util.Set;

import com.gl.emra.entity.Role;

public interface RoleService {

	public Role AddRole(Role role);

	public Set<Role> fetchAllRoles();

	public Role fetchById(long roleId);

	public void deleteById(long roleId);

}
