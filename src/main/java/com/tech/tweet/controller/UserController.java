package com.tech.tweet.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.tweet.exception.MyResourceNotFoundException;
import com.tech.tweet.model.GenericResponse;
import com.tech.tweet.model.LoginInput;
import com.tech.tweet.model.ResetPasswordRequest;
import com.tech.tweet.model.User;
import com.tech.tweet.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class UserController {

	private final UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/users/all")
	public Iterable<User> showUserList() {
		return userRepository.findAll();
	}

	@GetMapping("/signup")
	public String showSignUpForm(User user) {
		return "add-user";
	}

	@PostMapping("/register")
	@Transactional
	public User addUser(@RequestBody @Valid User user) {
		return userRepository.save(user);

	}

	@GetMapping("/edit/{id}")
	public User showUpdateForm(@PathVariable("id") long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		return user;
	}

	@PostMapping("/update/{id}")
	public User updateUser(@PathVariable("id") long id, @RequestBody @Valid User user) {
		return userRepository.save(user);

	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		userRepository.delete(user);
		return "deleted successfully";
	}

	@PostMapping("/login")
	public User login(@RequestBody @Valid LoginInput input) {
		User user = userRepository.findByName(input.getName());
		if (null != user && input.getPassword().equals(user.getPassword())) {
			return user;
		} else {
			throw new IllegalArgumentException("Invalid user name or password: Login failed");
		}

	}
	
	@PostMapping("/reset/updatePassword")
	public GenericResponse updatePassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
		System.out.println("passs......."+ resetPasswordRequest);
		User user = userRepository.findByEmail(resetPasswordRequest.getEmail());
		if (null == user) {
			throw new MyResourceNotFoundException("user not found");
		}
		if (StringUtils.isEmpty(resetPasswordRequest.getPassword())) {
			return new GenericResponse("400","password can't be empty");
		}
		userRepository.updatePassword(resetPasswordRequest.getEmail(), resetPasswordRequest.getPassword());
		return new GenericResponse("200","Your password has been rest successfully");

	}

}