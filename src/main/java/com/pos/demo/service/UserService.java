package com.pos.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


import com.pos.demo.entity.Users;
import com.pos.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	public String addUser(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword().toString(), BCrypt.gensalt(4)));
		userRepository.save(user);
		return "User Added!";
	}

	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		List<Users> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

}
