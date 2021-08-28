package com.douzone.securityEx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.securityEx.model.User;
import com.douzone.securityEx.repository.UserRepository;

@RestController
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/")
	public ResponseEntity<?> main(){
		return new ResponseEntity<>("main", HttpStatus.OK);	// 응답(Response)에 해당하는 HttpHeader와 HttpBody를 포함하는 클래스
	}

	@GetMapping("/api/user")
	public ResponseEntity<?> user(){
		return new ResponseEntity<>("user", HttpStatus.OK);	// 응답(Response)에 해당하는 HttpHeader와 HttpBody를 포함하는 클래스
	}
	
	@GetMapping("/api/admin")
	public ResponseEntity<?> admin(){
		return new ResponseEntity<>("admin", HttpStatus.OK);	// 응답(Response)에 해당하는 HttpHeader와 HttpBody를 포함하는 클래스
	}
	
	@GetMapping("/api/manage")
	public ResponseEntity<?> manager(){
		return new ResponseEntity<>("manager", HttpStatus.OK);	// 응답(Response)에 해당하는 HttpHeader와 HttpBody를 포함하는 클래스
	}
	
	@PostMapping("join")
	public String join(@RequestBody User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		userRepository.save(user);
		return "회원가입완료";
	}
}