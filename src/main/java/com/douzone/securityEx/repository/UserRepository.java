package com.douzone.securityEx.repository;

import org.springframework.stereotype.Repository;

import com.douzone.securityEx.model.User;

@Repository
public class UserRepository {

	public User findByUsername(String username) {
		
		User user = new User();
		user.setNo(0);
		user.setName("ssar");
		user.setPassword("123");
		user.setRole("USER_ADMIN");
		
		return user;		
	}
}