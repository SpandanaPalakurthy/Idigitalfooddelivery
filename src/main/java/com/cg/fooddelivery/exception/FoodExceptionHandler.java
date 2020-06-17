package com.cg.fooddelivery.exception;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Aspect
@Configuration
@ControllerAdvice
public class FoodExceptionHandler {
	private final Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());
	@ExceptionHandler(value = FoodDeliverySystemException.class)
 public ResponseEntity<ExceptionResult> handleBaseException(FoodDeliverySystemException e){     	
    	
    	slf4jLogger.error("Checked exception occurred",e);
    	ExceptionResult result = new ExceptionResult(e.getCode(), e.getMessage());
    	if(e.getCode() == 204) {
    		return new ResponseEntity<>(result,HttpStatus.NO_CONTENT);
    	}
    	
    	else if(e.getCode() == 400) {
    		return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    	}
    	
    	else  {
			 
    		return new ResponseEntity<>(result,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	}
}
