package com.ss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.dto.ProductRequest;
import com.ss.dto.ProductResponse;
import com.ss.entity.Product;
import com.ss.repo.OrderRepo;
import com.ss.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	OrderRepo orderRepo;
			
	public void createProduct(ProductRequest prodReq) {
		String model_name = prodReq.getModel_name();
		Double price = prodReq.getPrice();
		String color = prodReq.getColor();
		String category = prodReq.getCategory();
		String gender = prodReq.getGender();
		int size = prodReq.getSize();
		String brand = prodReq.getBrand();
		String details = prodReq.getDetails();
		int availability = prodReq.getAvailability();
		String rating = prodReq.getRating();
		
		Product product = new Product(model_name, price, color,category, gender, size, 
									brand, details,availability, rating);
		Product savedProd = productRepo.save(product);
		//log.info("Product{} is saved", product.getId());
	}
	
	
	public List<ProductResponse> getAllProducts(){
		List<Product> products = productRepo.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
	}
	
	
	
	
	
	private ProductResponse mapToProductResponse(Product prod) {
		int model_id = prod.getModel_id();
		String model_name = prod.getModel_name();
		Double price = prod.getPrice();
		String color = prod.getColor();
		String category = prod.getCategory();
		String gender = prod.getGender();
		int size = prod.getSize();
		String brand = prod.getBrand();
		String details = prod.getDetails();
		int availability = prod.getAvailability();
		String rating = prod.getRating();
		
		ProductResponse prodResponse = new ProductResponse(model_id, model_name, price,color,
										category,gender, size, brand, details,availability, 
										rating);
		return prodResponse;
	}

	public int updateProduct(ProductRequest prodReq) {
		int model_id = prodReq.getModel_id();
		String model_name = prodReq.getModel_name();
		Double price = prodReq.getPrice();
		String color = prodReq.getColor();
		String category = prodReq.getCategory();
		String gender = prodReq.getGender();
		int size = prodReq.getSize();
		String brand = prodReq.getBrand();
		String details = prodReq.getDetails();
		int availability = prodReq.getAvailability();
				
		int no=productRepo.updateProduct(model_name,price,color,category,gender,size,brand,details,availability,model_id);
		return no;
	}


	public Product getProductById(int id) {
		Optional<Product> product = productRepo.findById(id);
		
		if(product.isPresent()) {
			return product.get();
		} else {
		return null;
		}
	}
	
	public void deleteProductById(int id) {
		productRepo.deleteById(id);
	}
}
