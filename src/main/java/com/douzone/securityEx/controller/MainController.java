package com.douzone.securityEx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
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
}