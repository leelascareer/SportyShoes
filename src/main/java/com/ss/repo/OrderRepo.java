package com.ss.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ss.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

	@Query("SELECT o FROM Order o, Product p WHERE p.category LIKE %?1%")
	public List<Order> search(String keyword);

}
