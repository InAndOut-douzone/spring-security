package com.douzone.securityEx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Bootstrap Class
 * 
 * 1. ������ ��Ʈ ���ø����̼��� ��Ʈ��Ʈ����(Bootstrapping)
 * 2. ���� Ŭ������ ���� (Configuration Class)
 * 
 */

// @SpringBootApplication ��Ÿ ������̼�
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