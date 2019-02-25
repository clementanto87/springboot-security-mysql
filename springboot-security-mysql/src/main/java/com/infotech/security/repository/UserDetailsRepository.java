package com.infotech.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infotech.security.model.User;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String userName);
	
	public User findFirstByOrderByIdDesc();
}
