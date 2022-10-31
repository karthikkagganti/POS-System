package com.pos.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.demo.entity.Orders;
import com.pos.demo.service.OrderService;

@CrossOrigin
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order")
	public List<Orders> getOrders(){
		return orderService.getOrders();
	}
	
	@GetMapping("/billings")
	public List<Orders> getOrdersWithBilling(){
		return orderService.getOrdersWithBilling();
	}
	
	@GetMapping("/order/{orderid}")
	public Orders getOrdersByid(@PathVariable int orderid){
		return orderService.getOrdersById(orderid);
	}
	
	@PostMapping("/order")
		public int addOrders(@RequestBody Orders orders) {
			return orderService.addOrders(orders);
		}
	
	//changing the status of the order
	@PutMapping("/order/{orderid}")
	public String updateOrders(@PathVariable int orderid) {
		return orderService.updateOrders(orderid);
	}
		
}
