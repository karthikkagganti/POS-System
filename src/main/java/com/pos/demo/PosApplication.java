package com.pos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pos.demo.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.pos.demo.repository"})
@EntityScan(basePackages = {"com.pos.demo.entity"}) 
public class PosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}

}
