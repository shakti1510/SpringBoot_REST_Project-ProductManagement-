package com.jsp.springboot.product.service;



import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.product.entity.Product;
import com.jsp.springboot.product.utility.ResponseStructure;


public interface ProductService {
	
	public ResponseEntity<ResponseStructure<Product>> addProduct(Product product);
	
	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId);
	
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId,Product UpdatedProduct);
	
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId);
	
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct();
	
	public ResponseEntity<ResponseStructure<Product>> findByProductName(String productName);
	
	public ResponseEntity<ResponseStructure<List<Product>>> findProductBetweenPrice(int upperPrice,int lowerPrice);
	
	public ResponseEntity<ResponseStructure<List<Product>>> findProductByO();

}
