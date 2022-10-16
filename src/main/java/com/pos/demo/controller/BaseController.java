package com.pos.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

	@RequestMapping("/")
	public String home() {
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
}
