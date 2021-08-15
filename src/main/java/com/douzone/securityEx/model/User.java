package com.douzone.securityEx.model;

public class User {
	
	private int no;
	private String name;
	private String password;
	private String Role;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "User [no=" + no + ", name=" + name + ", password=" + password + ", Role=" + Role + "]";
	}
}