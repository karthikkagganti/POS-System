package com.pos.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.demo.entity.Items;
import com.pos.demo.entity.OrderedItems;
import com.pos.demo.entity.Orders;
import com.pos.demo.repository.ItemsRepository;
import com.pos.demo.repository.OrderRepository;
import com.pos.demo.repository.OrderedItemsRepository;

@Service
public class OrderedItemsService {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ItemsRepository itemsRepository;
	@Autowired
	OrderedItemsRepository orderedItemsRepository;

	
	public void orderedItems(int orderid, int itemsid, int quantity) {
		// TODO Auto-generated method stub
		OrderedItems orderedItems = new OrderedItems();
		Orders order = orderRepository.findById(orderid).get();
		Items item = itemsRepository.findById(itemsid).get();
		orderedItems.setItems(item);
		order.addItems(orderedItems);
//		orderedItems.setOrders(order);
		orderedItems.setQuantity(quantity);
		orderedItems.setItemName(item.getName());
		orderedItems.setSubTotal(item.getPrice() * quantity);
		order.setOrdervalue(order.getOrdervalue() + orderedItems.getSubTotal());
		orderedItemsRepository.save(orderedItems);
		orderRepository.save(order);
	}

	public List<OrderedItems> getOrderedItems() {
		// TODO Auto-generated method stub
		List<OrderedItems> orderedItems = new ArrayList<>();
		orderedItemsRepository.findAll().forEach(orderedItems::add);
		return orderedItems;
	}

	public List<Integer> getOrderedItemsById(int id) {
		// TODO Auto-generated method stub
		List<Integer> nums = new ArrayList<>();
		OrderedItems ordereditems = orderedItemsRepository.findById(id).get();
		nums.add(ordereditems.getItems().getItemsid());
		nums.add(ordereditems.getOrders().getOrderid());
		return nums;
	}

	public String deleteOrderedItems(int id) {
		// TODO Auto-generated method stub
		OrderedItems orderedItems = orderedItemsRepository.findById(id).get();
		orderedItemsRepository.delete(orderedItems);
		return "Deleted!";
	}

	public String changeStatus(int id) {
		// TODO Auto-generated method stub
		OrderedItems orderedItems = orderedItemsRepository.findById(id).get();
		orderedItems.setStatus("Done");
		orderedItemsRepository.save(orderedItems);
		return "Changed the Status";
	}

}
