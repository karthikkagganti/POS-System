package com.pos.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.demo.entity.Customer;
import com.pos.demo.entity.Orders;
import com.pos.demo.repository.CustomerRepository;
import com.pos.demo.repository.OrderRepository;

@Service
public class CustomerService {
	@Autowired 
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public int addNewCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer.getCustid();
	}
	
	public List<Customer> viewCustomers(){
		List<Customer> customers= new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}
	
	public String deleteCustomer(int custid) {
		customerRepository.deleteById(custid);
		return "Customer Deleted!";
	}
	
	public Customer viewCustomerById(int custid) {
		return customerRepository.findById(custid).get();
	}
	
}
