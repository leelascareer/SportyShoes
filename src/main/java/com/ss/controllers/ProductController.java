package com.ss.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ss.dto.ProductRequest;
import com.ss.dto.ProductResponse;
import com.ss.entity.Product;
import com.ss.service.ProductService;

@RestController
//@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService prodService;
	
	@GetMapping(value = "/add", produces ={MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	public ModelAndView displayProductPage(@ModelAttribute("productRequest")ProductRequest productRequest, BindingResult result, ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addproduct");
		return modelAndView;
	}
	
	
	  @GetMapping(value = "/addproduct",produces = { MediaType.APPLICATION_JSON_VALUE})
	  @ResponseStatus(HttpStatus.CREATED) 
	  public ModelAndView addProduct(@ModelAttribute("productRequest")ProductRequest productRequest, BindingResult result, ModelMap model) {
	  prodService.createProduct(productRequest); 
	  ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("homepage");
		return modelAndView;
	  }
	 
	
		
	@GetMapping(value = "/listproducts", produces = { MediaType.APPLICATION_JSON_VALUE})
	//public ModelAndView listProducts(ModelMap model) {
	public ModelAndView listProducts(@ModelAttribute("productRequest")ProductRequest productRequest, BindingResult result, ModelMap model) {	
		ModelAndView modelAndView = new ModelAndView();
		List<ProductResponse> listOfProducts = prodService.getAllProducts();
		model.addAttribute("list", listOfProducts);
		modelAndView.setViewName("listproducts");
		return modelAndView;
	}
	
	@GetMapping(value = "/getDetails/{model_id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ModelAndView getDetails(@PathVariable int model_id,  @ModelAttribute("productRequest")ProductRequest productRequest, ModelMap model) {	
		ModelAndView modelAndView = new ModelAndView();
		Product selectedProduct = prodService.getProductById(model_id);
		model.addAttribute("selectedProduct", selectedProduct);
		modelAndView.setViewName("productdetails");
		return modelAndView;
	}
	
	@GetMapping(value = "/update/{model_id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ModelAndView updateInventory(@PathVariable int model_id, @ModelAttribute("productRequest")ProductRequest productRequest,BindingResult result, ModelMap model) {
		model.addAttribute("productRequest", new ProductRequest());
		ModelAndView modelAndView = new ModelAndView();
		int updated = prodService.updateProduct(productRequest);
		List<ProductResponse> listOfProducts = prodService.getAllProducts();
		model.addAttribute("list", listOfProducts);
		modelAndView.setViewName("listproducts");
		return modelAndView;
	}
	
	@GetMapping(value = "/delete/{model_id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ModelAndView deleteProduct(@PathVariable int model_id, @ModelAttribute("productRequest")ProductRequest productRequest,BindingResult result, ModelMap model) {
		model.addAttribute("productRequest", new ProductRequest());
		ModelAndView modelAndView = new ModelAndView();
		prodService.deleteProductById(model_id);
		List<ProductResponse> listOfProducts = prodService.getAllProducts();
		model.addAttribute("list", listOfProducts);
		modelAndView.setViewName("listproducts");
		return modelAndView;
	}
}
