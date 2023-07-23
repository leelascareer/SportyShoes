package com.ss.dto;

import com.ss.entity.Product;
import com.ss.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

public class OrderRequest {
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int order_id;
	
	@Column(name="model_id")
	private int model_id;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="status_id")
	private int status_id;
	
	@Column(name="dateofpurchase")
	private String dateofpurchase;
	
	@OneToOne
	@MapsId
    @JoinColumn(name = "model_id")
	private Product product;
	
	@OneToOne
	@MapsId
    @JoinColumn(name = "userid")
	private User user;
	
	public OrderRequest() {
	}

	public OrderRequest(int order_id, int model_id, int userid, int status_id,
			String dateofpurchase, Product product, User user) {
		this.order_id = order_id;
		this.model_id = model_id;
		this.userid = userid;
		this.status_id = status_id;
		this.dateofpurchase = dateofpurchase;
		this.product = product;
		this.user = user;
	}
	
	public OrderRequest(int order_id, int model_id, int userid, int status_id,
			String dateofpurchase) {
		this.order_id = order_id;
		this.model_id = model_id;
		this.userid = userid;
		this.status_id = status_id;
		this.dateofpurchase = dateofpurchase;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getDateofpurchase() {
		return dateofpurchase;
	}

	public void setDateofpurchase(String dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
