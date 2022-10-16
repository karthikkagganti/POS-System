package com.pos.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.demo.entity.Expenses;
import com.pos.demo.service.ExpensesService;

@CrossOrigin
@RestController
public class ExpensesController {

	@Autowired
	ExpensesService expensesService;
	
	@PostMapping("/expenses")
	public String addExpenses(@RequestBody Expenses expenses) {
		return expensesService.addExpenses(expenses);
	}
}
