package com.jsp.springboot.product.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.product.exception.ProductNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> productNotFoundByIdException(ProductNotFoundByIdException e){
		
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(e.getMessage());
		errorStructure.setErrorData("Product with the requested Id is not present!!!");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
		
	}
}
