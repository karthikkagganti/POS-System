package com.pos.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.demo.entity.Expenses;
import com.pos.demo.repository.ExpensesRepository;

@Service
public class ExpensesService {
	
	@Autowired
	ExpensesRepository expenseRepository;

	public String addExpenses(Expenses expenses) {
		// TODO Auto-generated method stub
		expenseRepository.save(expenses);
		return "Added Expenses!";
	}
	
	
}
