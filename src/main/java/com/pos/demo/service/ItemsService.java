package com.pos.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.demo.entity.Items;
import com.pos.demo.repository.ItemsRepository;

@Service
public class ItemsService {
	@Autowired
	private ItemsRepository itemsRepository;
	
	public List<Items> getItems() {
		List<Items> items = new ArrayList<>();
		itemsRepository.findAll().forEach(items::add);
		return items;
	}
	
	public String addItems(Items items) {
		itemsRepository.save(items);
		return "Items was added!";
	}
	
	public String updateItems(int itemsid,Items items) {
		
		Items item = itemsRepository.findById(itemsid).get();
		item.setPrice(items.getPrice());
		item.setDescription(items.getDescription());
		item.setName(items.getName());
		
		itemsRepository.save(item);
		return "Item was updated!";
	}
}
