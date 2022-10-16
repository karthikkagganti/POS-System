package com.pos.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expenseid;
	private String name;
	private float amount;
	private LocalDate orderDate = java.time.LocalDate.now();
	private LocalTime orderTime = java.time.LocalTime.now();

	public Expenses(int expenseId, String name, float amount) {
		super();
		this.expenseid = expenseId;
		this.name = name;
		this.amount = amount;
	}

	public Expenses() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getExpenseid() {
		return expenseid;
	}

	public void setExpenseid(int expenseid) {
		this.expenseid = expenseid;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}

}
