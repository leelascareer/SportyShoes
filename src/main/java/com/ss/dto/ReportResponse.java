package com.ss.dto;


public class ReportResponse {
	
	int order_id;
	int model_id;
	String model_name;
	String category;
	int size;
	String color;
	double price;
	String dateofpurchase;
	int userid;
	String f_name;
	String l_name;
	String status;
	
	
	public ReportResponse(int order_id, int userid, String f_name, String lastname, int modelid, 
			String modelname, String category,int size, String color, double price, 
			String dateofpurchase, String orderstatus) {
		this.order_id = order_id;
		this.userid = userid;
		this.f_name = f_name;
		this.l_name = lastname;
		this.model_id = modelid;
		this.model_name = modelname;
		this.category = category;
		this.size = size;
		this.color = color;
		this.price = price;
		this.dateofpurchase = dateofpurchase;
		this.status = orderstatus;
	}
	
	public int getModel_id() {
		return model_id;
	}
	public void setModel_id(int modelid) {
		this.model_id = modelid;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String modelname) {
		this.model_name = modelname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	/*
	 * public int getOrderid() { return orderid; }
	 * public void setOrderid(int orderid) {
	 * this.orderid = orderid; }
	 */
	public String getDateofpurchase() {
		return dateofpurchase;
	}
	public void setDateofpurchase(String dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String lastname) {
		this.l_name = lastname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String orderstatus) {
		this.status = orderstatus;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
		

}
