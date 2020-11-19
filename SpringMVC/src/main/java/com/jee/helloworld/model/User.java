package com.jee.helloworld.model;

public class User {
	private String username;
	private String password;

	public User() {
	}

	public User (String pUsername, String pPassword) {
		username = pUsername;
		password = pPassword;
	}

	public String getUsername () {
		return username;
	}

	public void setUsername (String pUsername) {
		username = pUsername;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword (String pPassword) {
		password = pPassword;
	}
}
