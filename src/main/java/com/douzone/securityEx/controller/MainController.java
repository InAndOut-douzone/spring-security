package com.douzone.securityEx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class MainController {

	@GetMapping("/list")
	public ResponseEntity<?> main(){
		return new ResponseEntity<>("1", HttpStatus.OK);	// 응답(Response)에 해당하는 HttpHeader와 HttpBody를 포함하는 클래스
	}

}