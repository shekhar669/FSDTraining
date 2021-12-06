package com.tweetapp.model;

import javax.validation.constraints.NotBlank;

public class LoginInput {
	@NotBlank(message = "Name is mandatory")
	private String loginId;

	@NotBlank(message = "Email is mandatory")
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
