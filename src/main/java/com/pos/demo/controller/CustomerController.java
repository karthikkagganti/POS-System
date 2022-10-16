package com.pos.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.demo.entity.Customer;
import com.pos.demo.service.CustomerService;

@CrossOrigin
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/cust")
	public int addNewCustomer(@RequestBody Customer customer) {
		return customerService.addNewCustomer(customer);
		 
	}
	
	@GetMapping(value="/cust")
	public List<Customer> viewCustomers(){
		return customerService.viewCustomers();
	}
	

	@GetMapping(value="/cust/{custid}")
	public Customer viewCustomersById(@PathVariable int custid){
		return customerService.viewCustomerById(custid);
	}
	
	@DeleteMapping("/cust/{custid}")
	public String deleteCustomer(@PathVariable int custid) {
		return customerService.deleteCustomer(custid); 
	}
	
}