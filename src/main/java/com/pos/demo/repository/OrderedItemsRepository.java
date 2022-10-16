package com.pos.demo.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pos.demo.entity.OrderedItems;
import com.pos.demo.entity.Orders;

public interface OrderedItemsRepository extends CrudRepository<OrderedItems, Integer> {
	Optional<List<OrderedItems>> findAllByOrderDate(LocalDate date);
}
