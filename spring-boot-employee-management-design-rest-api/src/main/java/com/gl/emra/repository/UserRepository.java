package com.gl.emra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.emra.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findByUserName(String userName);

}
