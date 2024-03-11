package com.jsp.springboot.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.springboot.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("Select p from Product p where p.productName=:productName")
	Product findByProductName(String productName);
	
	@Query("Select p from Product p where p.productPrice between :upperPrice and :lowerPrice")
	List<Product> findProductBetweenPrice(int upperPrice,int lowerPrice);
	
	@Query("Select p from Product p where p.productName like '%O%' ")
	List<Product> findProductByO();
}
