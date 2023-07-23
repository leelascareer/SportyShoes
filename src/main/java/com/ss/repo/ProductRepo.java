package com.ss.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ss.entity.Product;

@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Modifying
	@Query("UPDATE Product p set p.model_name=?1, p.price=?2, p.color=?3, p.category=?4, p.gender=?5,"
			+ " p.size=?6, p.brand=?7, p.details=?8, p.availability=?9 where p.model_id=?10")
  	public int updateProduct(String model_name, Double price, String color,
			String category, String gender, int size, String brand,
			String details, int availability, int model_id);
} 
