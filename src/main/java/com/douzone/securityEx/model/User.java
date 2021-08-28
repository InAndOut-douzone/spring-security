package com.douzone.securityEx.model;

public class User {
	
	private int no;
	private String username;
	private String password;
	private String Role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int no, String username, String password, String role) {
		super();
		this.no = no;
		this.username = username;
		this.password = password;
		Role = role;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	@Override
	public String toString() {
		return "User [no=" + no + ", username=" + username + ", password=" + password + ", Role=" + Role + "]";
	}
}