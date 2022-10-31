package com.pos.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {

	@GetMapping("/")
	public String hello() {
		return "index";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/item")
	public String items() {
		return "items";
	}

	@RequestMapping("/customer")
	public String customers() {
		return "viewCustomers";
	}

	@RequestMapping("/feedback")
	public String feedback(){
		return "customers";
	}

	@RequestMapping("/expenses")
	public String expenses() {
		return "expenses";
	}

	@RequestMapping("/reports")
	public String reports() {
		return "reports";
	}

	@RequestMapping("/orders")
	public String orders() {
		return "orders";
	}
	
	@RequestMapping("/billing")
	public String billing() {
		return "billing";
	}
}
