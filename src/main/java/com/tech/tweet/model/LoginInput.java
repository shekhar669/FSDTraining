package com.tech.tweet.model;

import javax.validation.constraints.NotBlank;


public class LoginInput {
	 @NotBlank(message = "Name is mandatory")
	 private String name;
	    
	 @NotBlank(message = "Email is mandatory")
	  private String password;

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
	 
}
