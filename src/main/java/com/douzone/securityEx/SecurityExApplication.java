package com.douzone.securityEx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Bootstrap Class
 * 
 * 1. 스프링 부트 애플리케이션의 부트스트래핑(Bootstrapping)
 * 2. 설정 클래스로 역할 (Configuration Class)
 * 
 */

// @SpringBootApplication 메타 어노테이션
// @SpringBootConfiguration(alias for @Configuration)
// @ComponentScan
// @AutoConfiguration 
// 
//
//

@SpringBootApplication
public class SecurityExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityExApplication.class, args); 
	}	
}