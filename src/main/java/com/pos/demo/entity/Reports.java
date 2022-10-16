package com.pos.demo.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Reports {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportid;
	private float total;
	private int noSales;
	private LocalDate reportDate = java.time.LocalDate.now();

	@OneToMany(targetEntity = Expenses.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "exp_fk", referencedColumnName = "reportid")
	private Set<Expenses> expenses = new HashSet<>();

	

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ordered_for_the_day", joinColumns = @JoinColumn(name = "reportid", referencedColumnName = "reportid"), inverseJoinColumns = @JoinColumn(name = "id",referencedColumnName = "id"))
	private Set<OrderedItems> orderedItems = new HashSet<>();

	public Reports(int reportid, float total) {
		super();
		this.reportid = reportid;
		this.total = total;
	}

	public Reports() {

	}

	
	
	public int getNoSales() {
		return noSales;
	}

	public void setNoSales(int noSales) {
		this.noSales = noSales;
	}

	public Set<OrderedItems> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(Set<OrderedItems> orderedItems) {
		this.orderedItems = orderedItems;
	}

	public int getReportid() {
		return reportid;
	}

	public void setReportid(int reportid) {
		this.reportid = reportid;
	}

	

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public LocalDate getReportDate() {
		return reportDate;
	}

	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}
	public Set<Expenses> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expenses> expenses) {
		this.expenses = expenses;
	}

	public void addExpenses(List<Expenses> expenses2) {
		// TODO Auto-generated method stub
		expenses2.forEach(this.expenses::add);
	}
	
	public void addOrders(List<OrderedItems> orders2) {
		// TODO Auto-generated method stub
		orders2.forEach(this.orderedItems::add);
	}
	
	

}
