package com.project.ms.stockprice.rest.exception.handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StockRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StockErrorResponse> handleException(StockNotFoundException exc){
		
		StockErrorResponse error = new StockErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<StockErrorResponse>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<StockErrorResponse> handleAllException(Exception exc){
		
		StockErrorResponse error = new StockErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<StockErrorResponse>(error,HttpStatus.BAD_REQUEST);
		
	}
}
