package com.pos.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.pos.demo.entity.Customer;
import com.pos.demo.entity.Expenses;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
