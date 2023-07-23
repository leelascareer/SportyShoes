package com.ss.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="order_status")
public class OrderStatus {

	@Id
	@Column(name="status_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int status_id;
	
	@Column(name="order_status")
	private String order_status;
	
	//@OneToMany(mappedBy="status_id")
	//@JoinColumn(name="status_id")
	@OneToMany
	@PrimaryKeyJoinColumn
    private Set<Order> orders;
	
	public OrderStatus(int status_id, String order_status, Set<Order> orders) {
		this.status_id = status_id;
		this.order_status = order_status;
		this.orders = orders;
	}
	
	public OrderStatus() {
		this.status_id = status_id;
		this.order_status = order_status;
		this.orders = orders;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	
	
	
	
}
