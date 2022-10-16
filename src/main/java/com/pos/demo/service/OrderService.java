package com.pos.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pos.demo.entity.Items;
import com.pos.demo.entity.Orders;
import com.pos.demo.repository.ItemsRepository;
import com.pos.demo.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemsRepository itemsRepository;
	

	
	public List<Orders> getOrders() {
		List<Orders> orders = new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}
	
	public int addOrders() {
		Orders orders = new Orders();
		orderRepository.save(orders);
		return orders.getOrderid();
	}
	
	public String updateOrders(int orderid) {
		Orders order = orderRepository.findById(orderid).get();
		order.setStatus("Done");
		orderRepository.save(order);
		return "Order was updated";
	}
	
	public Orders getOrdersById(int orderid) {
		return orderRepository.findById(orderid).get();
	}
	
}
