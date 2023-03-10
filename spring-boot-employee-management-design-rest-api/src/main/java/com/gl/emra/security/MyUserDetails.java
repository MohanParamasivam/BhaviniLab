package com.gl.emra.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.gl.emra.entity.Role;
import com.gl.emra.entity.User;

public class MyUserDetails implements org.springframework.security.core.userdetails.UserDetails {

	private final String username;
	private final String password;
	private final List<GrantedAuthority> authorities;

	public MyUserDetails(User user) {
		this.username = user.getUserName();
		this.password = user.getPassword();
		this.authorities = user.getRoles().stream().map(Role::getRoleName).map(roleName -> "ROLE_" + roleName)
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println(" **********************************");
		System.out.println(this.authorities);
		System.out.println(" **********************************");
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;

	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}