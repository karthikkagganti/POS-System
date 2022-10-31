package com.pos.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderid;
	private float ordervalue;
	private String status = "ordered";
	private int tableNo;
	private LocalDate orderDate = java.time.LocalDate.now();
	private LocalTime orderTime = java.time.LocalTime.now();
//	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "orders_ordereditems", joinColumns = @JoinColumn(name = "orderid", referencedColumnName = "order_id"), inverseJoinColumns = @JoinColumn(name = "id",referencedColumnName = "id"))
	private List<OrderedItems> orders = new ArrayList<>();
	
	

	public Orders() {

	}

	public Orders(int orderid, float ordervalue, String status, LocalDate orderDate, LocalTime orderTime, int tableNo) {
		super();
		this.orderid = orderid;
		this.ordervalue = ordervalue;
		this.status = status;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.tableNo = tableNo;
	}

	
	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public LocalTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public float getOrdervalue() {
		return ordervalue;
	}

	public void setOrdervalue(float ordervalue) {
		this.ordervalue = ordervalue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderedItems> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderedItems> orders) {
		this.orders = orders;
	}
	
	public void addItems(OrderedItems orderedItems) {
		this.orders.add(orderedItems);
	}
}
