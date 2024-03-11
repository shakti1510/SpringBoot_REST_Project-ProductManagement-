package com.jsp.springboot.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.product.entity.Product;
import com.jsp.springboot.product.service.ProductService;
import com.jsp.springboot.product.utility.ResponseStructure;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products/addProduct")
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@GetMapping("/products/findByProductId/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findByProductId(@PathVariable int productId) {
		return productService.findByProductId(productId);
	}

	@PutMapping("/products/updateByProductId/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(@PathVariable int productId,@RequestBody Product updatedProduct) {
		return productService.updateByProductId(productId,updatedProduct);
	}

	@DeleteMapping("/products/deleteByProductId/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(@PathVariable int productId) {
		return productService.deleteByProductId(productId);
	}

	@GetMapping("/products/findByProductName/{productName}")
	public ResponseEntity<ResponseStructure<Product>> findByProductName(@PathVariable String productName) {
		return productService.findByProductName(productName);
	}
	
	@GetMapping("/products/findAllProduct")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct(){
		return productService.findAllProduct();
	}
	@GetMapping("/products/findProductBetweenPrice/{upperPrice}&{lowerPrice}")
	public ResponseEntity<ResponseStructure<List<Product>>> findProductBetweenPrice(@PathVariable int upperPrice,@PathVariable int lowerPrice){
		return productService.findProductBetweenPrice(upperPrice, lowerPrice);
	}
	@GetMapping("/products/findProductByO")
	public ResponseEntity<ResponseStructure<List<Product>>> findProductByO(){
		return productService.findProductByO();
	}
}
