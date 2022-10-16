package com.pos.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pos.demo.entity.MyUserDetails;
import com.pos.demo.entity.Users;
import com.pos.demo.repository.UserRepository;

@Service
public class MyUserDeatilsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Users> user = userRepository.findByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException("Email not found: " + email));

		return user.map(MyUserDetails::new).get();
	}

}
