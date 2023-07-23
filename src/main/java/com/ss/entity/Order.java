package com.ss.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int order_id;
	
	@Column(name="model_id")
	private int model_id;
	
	
	 @Column(name="userid", insertable=false, updatable=false) 
	 private int userid;
	 
	@Column(name="status_id")
	private int status_id;
	
	@Column(name="dateofpurchase")
	private String dateofpurchase;
	
	/*
	 * @OneToOne
	 * 
	 * @MapsId
	 * 
	 * @JoinColumn(name = "model_id")
	 * //@PrimaryKeyJoinColumn private Product
	 * product;
	 */
	
	@ManyToOne
	@MapsId
	@JoinColumn(name="model_id", nullable = false)
	private Product product;
	
	
	/*
	 * @OneToOne
	 * 
	 * @MapsId
	 * 
	 * @JoinColumn(name = "userid") private User user;
	 */
	@ManyToOne
	@MapsId
	@JoinColumn(name="userid", nullable = false)
	private User user;
	
	@ManyToOne
	@MapsId	
    @JoinColumn(name="status_id")
    private OrderStatus orderStatus;

	
	
	  public Order() { }
	 
	

	public Order(int order_id, int model_id, int userid, int status_id,
			String dateofpurchase, Product product, User user, OrderStatus orderSatus) {
		this.order_id = order_id;
		this.model_id = model_id;
		this.userid = userid;
		this.status_id = status_id;
		this.dateofpurchase = dateofpurchase;
		this.product = product;
		this.user = user;
		this.orderStatus = orderStatus;
	}

	public Order(int order_id, Product product, User user) {
		super();
		this.order_id = order_id;
		this.product = product;
		this.user = user;
	}


	public Order(int order_id, int model_id, int status_id,
			String dateofpurchase, Product product, User user,
			OrderStatus orderStatus) {
		super();
		this.order_id = order_id;
		this.model_id = model_id;
		this.status_id = status_id;
		this.dateofpurchase = dateofpurchase;
		this.product = product;
		this.user = user;
		this.orderStatus = orderStatus;
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

	
	  public int getUserid() { return userid; }
	  
	  public void setUserid(int userid) { this.userid
	  = userid; }
	 

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
	
	public OrderStatus getStatus() {
		return orderStatus;
	}

	public void setProduct(OrderStatus orderSatus) {
		this.orderStatus = orderSatus;
	}

	
	}
