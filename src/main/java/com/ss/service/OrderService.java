package com.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.dto.ReportResponse;
import com.ss.entity.Order;
import com.ss.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo orderRepo;

	public List<ReportResponse> getAllOrders() {
		List<Order> orders = orderRepo.findAll();
		return orders.stream().map(this::mapToReportResponse).toList();

	}

	private ReportResponse mapToReportResponse(Order orders) { 
		int order_id = orders.getOrder_id(); 
		int userid = orders.getUser().getUserid(); 
		String f_name = orders.getUser().getF_name();
		String l_name = orders.getUser().getL_name();
		int model_id = orders.getModel_id(); 
		String model_name = orders.getProduct().getModel_name(); 
		String category = orders.getProduct().getCategory();
		int size = orders.getProduct().getSize(); 
		String color = orders.getProduct().getColor(); 
		double price = orders.getProduct().getPrice(); 
		String dateofPurchase = orders.getDateofpurchase();
		String order_status = orders.getStatus().getOrder_status();
		
		ReportResponse rr = new ReportResponse(order_id, userid, f_name, l_name, model_id,
							model_name, category, size, color, price, dateofPurchase, order_status);
		return rr;
	}

	public List<ReportResponse> listAll(String keyword) {
		if (keyword != null) {
			List<Order> orders =  orderRepo.search(keyword);
			return orders.stream().map(this::mapToReportResponse).toList();
		} else {
			List<Order> orders =  orderRepo.findAll();
			return orders.stream().map(this::mapToReportResponse).toList();
		}
	}
	
	

}
