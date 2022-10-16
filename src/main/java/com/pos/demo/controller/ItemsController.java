package com.pos.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.demo.entity.Items;
import com.pos.demo.service.ItemsService;

@CrossOrigin
@RestController
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	@GetMapping(value="/items")
	public ResponseEntity<List<Items>> getItems(){
		return new ResponseEntity<>(itemsService.getItems(), HttpStatus.OK);	  		
	}
	
	@PostMapping("/items")
	public String addItems(@RequestBody Items items) {
		return itemsService.addItems(items);
	}
	
	@PutMapping("/items/{itemsid}")
	public String updateItems(@PathVariable int itemsid, @RequestBody Items items) {
		return itemsService.updateItems(itemsid,items);
	}
}
