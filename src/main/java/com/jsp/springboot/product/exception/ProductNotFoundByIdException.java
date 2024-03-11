package com.jsp.springboot.product.exception;

public class ProductNotFoundByIdException extends RuntimeException{
	private String message;

	public ProductNotFoundByIdException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
