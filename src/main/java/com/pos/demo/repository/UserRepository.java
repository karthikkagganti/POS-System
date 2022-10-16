package com.pos.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.demo.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByEmail(String email);
}
