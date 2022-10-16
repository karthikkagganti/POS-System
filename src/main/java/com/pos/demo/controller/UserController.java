package com.pos.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.demo.entity.Users;
import com.pos.demo.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public String addUser(@RequestBody Users user) {
		return userService.addUser(user);
	}

	@GetMapping("/users")
	public List<Users> getUsers() {
		return userService.getUsers();
	}

}
