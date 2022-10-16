package com.pos.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.demo.entity.OrderedItems;
import com.pos.demo.service.OrderedItemsService;

@CrossOrigin
@RestController
public class OrderedItemsController {
	@Autowired
	private OrderedItemsService orderedItemsService;
	
	@PostMapping("/orderedItems/{orderid}/{itemsid}/{quantity}")
	public String orderedItems(@PathVariable int orderid, @PathVariable int itemsid,@PathVariable int quantity) {
		orderedItemsService.orderedItems(orderid,itemsid, quantity);
		return"added items to orders";
	}
	
	@GetMapping("/orderedItems")
	public List<OrderedItems> getOrderedItems()
	{
		return orderedItemsService.getOrderedItems();
	}
	@GetMapping("/orderedItems/{id}")
	public List<Integer> getOrderedItemsById(@PathVariable int id)
	{
		return orderedItemsService.getOrderedItemsById(id);
	}
	@PutMapping("/orderedItems/{id}")
	public String changeStatus(@PathVariable int id) {
		return orderedItemsService.changeStatus(id);
	}
	
	@DeleteMapping("/orderedItems/{id}")
	public String deleteOrderedItems(@PathVariable int id) {
		return orderedItemsService.deleteOrderedItems(id);
	}
}
