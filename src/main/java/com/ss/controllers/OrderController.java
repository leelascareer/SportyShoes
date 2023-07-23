package com.ss.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ss.dto.OrderRequest;
import com.ss.dto.ReportResponse;
import com.ss.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	
	@GetMapping(value = "/listorders", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ModelAndView listUsers(@ModelAttribute("orderRequest")OrderRequest orderRequest, BindingResult result, ModelMap model) {	
		ModelAndView modelAndView = new ModelAndView();
		List<ReportResponse> listOfOrders = orderService.getAllOrders();
		model.addAttribute("list", listOfOrders);
		modelAndView.setViewName("listorders");
		return modelAndView;
	}	
	
	
	  @GetMapping("/listorders") 
	  public ModelAndView filterOrders(Model model, @Param("keyword") String keyword) { 
	  List<ReportResponse> filterOrders = orderService.listAll(keyword); 
	  ModelAndView modelAndView = new ModelAndView();
	  model.addAttribute("list", filterOrders);
	  model.addAttribute("keyword", keyword);
	  modelAndView.setViewName("listorders"); 
	  return modelAndView;
	  }
	 
}
