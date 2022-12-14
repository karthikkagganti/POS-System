package com.pos.demo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.pos.demo.entity.Customer;
import com.pos.demo.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

	Optional<List<Orders>> findByTableNoAndStatus(int tableNo, String status);
	Optional<List<Orders>> findByStatus(String status);
}
