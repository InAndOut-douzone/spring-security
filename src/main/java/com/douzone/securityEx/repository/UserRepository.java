package com.douzone.securityEx.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.douzone.securityEx.model.User;

@Repository
public class UserRepository {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public User findByUsername(String username) {
		
		User user = new User();
		user.setNo(0);
		user.setUsername("ssar");
		user.setPassword(bCryptPasswordEncoder.encode("가"));
		user.setRole("USER_ADMIN");
		
		return user;		
	}
	
	public void save(User user) {
		System.out.println("레파지토리 저장 실행됨");
	}
}