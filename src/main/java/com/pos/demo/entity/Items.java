package com.pos.demo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "items_id")
	private int itemsid;
	private String name;
	private String description;
	private float price;

	@JsonIgnore
	@OneToMany(mappedBy = "items", cascade = CascadeType.ALL)
	private List<OrderedItems> items = new ArrayList<>();

	public Items() {

	}

	public Items(int itemsid, String name, String description, float price) {
		super();
		this.itemsid = itemsid;
		this.name = name;
		this.description = description;
		this.price = price;

	}

	public int getItemsid() {
		return itemsid;
	}

	public void setItemsid(int itemsid) {
		this.itemsid = itemsid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<OrderedItems> getItems() {
		return items;
	}

	public void setItems(List<OrderedItems> items) {
		this.items = items;
	}

}
