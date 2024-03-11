package com.jsp.springboot.product.serviceimpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.product.entity.Product;
import com.jsp.springboot.product.exception.ProductNotFoundByIdException;
import com.jsp.springboot.product.repository.ProductRepository;

import com.jsp.springboot.product.service.ProductService;
import com.jsp.springboot.product.utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	@Override
	public ResponseEntity<ResponseStructure<Product>> addProduct(Product product) {
		Product p=productRepository.save(product);
		ResponseStructure<Product> responseStructure =new ResponseStructure<Product>();
		responseStructure.setData(p);
		responseStructure.setMessage("Data added Successfully!!");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);
		
	}
	
	@Override
	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId) {
		Optional<Product> optional=productRepository.findById(productId);
		if(optional.isPresent()) {
			Product product=optional.get();
			ResponseStructure<Product> responseStructure =new ResponseStructure<Product>();
			responseStructure.setData(product);
			responseStructure.setMessage("Data Found Successfully!!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new ProductNotFoundByIdException("Product is not present");
		}
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product updatedProduct) {
		Optional<Product> optional=productRepository.findById(productId);
		if(optional.isPresent()) {
			Product existingProduct=optional.get();
			updatedProduct.setProductId(existingProduct.getProductId());
			productRepository.save(updatedProduct);
			ResponseStructure<Product> responseStructure =new ResponseStructure<Product>();
			responseStructure.setData(updatedProduct);
			responseStructure.setMessage("Data has been Updated Successfully!!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new ProductNotFoundByIdException("Product is not present");
		}
	
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId) {
		Optional<Product> optional=productRepository.findById(productId);
		if(optional.isPresent()) {
			Product product=optional.get();
			productRepository.delete(product);
			ResponseStructure<Product> responseStructure =new ResponseStructure<Product>();
			responseStructure.setData(product);
			responseStructure.setMessage("Data has been Updated Successfully!!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);

		}
		else {
			throw new ProductNotFoundByIdException("Product is not present");
		}
		
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
		List<Product> products=productRepository.findAll();
		ResponseStructure<List<Product>> responseStructure =new ResponseStructure<List<Product>>();
		responseStructure.setData(products);
		responseStructure.setMessage("Data Found Successfully!!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findByProductName(String productName) {
		Product product = productRepository.findByProductName(productName);
		ResponseStructure<Product> responseStructure =new ResponseStructure<Product>();
		responseStructure.setData(product);
		responseStructure.setMessage("Data Found Successfully!!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findProductBetweenPrice(int upperPrice, int lowerPrice) {
		List<Product> products=productRepository.findProductBetweenPrice(upperPrice, lowerPrice);
		ResponseStructure<List<Product>> responseStructure =new ResponseStructure<List<Product>>();
		responseStructure.setData(products);
		responseStructure.setMessage("Data Found Successfully!!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findProductByO() {
		List<Product> products=productRepository.findProductByO();
		ResponseStructure<List<Product>> responseStructure =new ResponseStructure<List<Product>>();
		responseStructure.setData(products);
		responseStructure.setMessage("Data Found Successfully!!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,HttpStatus.FOUND);
	}

}
