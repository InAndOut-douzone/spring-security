package com.douzone.securityEx.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.douzone.securityEx.model.User;
import com.douzone.securityEx.repository.UserRepository;

@Service
public class PrincipalDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	
	// 시큐리티 session내부 Authentication (내부 UserDetails) return이 되면서 저장
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("PrincipalDetailsService is Run");
		User userEntity = userRepository.findByUsername(username);
		System.out.println("userEntity:"+userEntity);
	
		return new PrincipalDetails(userEntity);
	}	
}