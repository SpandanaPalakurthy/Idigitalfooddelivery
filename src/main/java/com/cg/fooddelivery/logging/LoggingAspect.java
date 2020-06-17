package com.cg.fooddelivery.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.cg.fooddelivery.exception.FoodDeliverySystemException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Aspect
@Configuration
public class LoggingAspect {
	
	private final Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());
	 
	private ObjectMapper mapper = new ObjectMapper();

	@Before("execution(* com.cg.fooddelivery.service.impl.AdminService..*(..))")
	public void controllerLogging(JoinPoint joint) throws FoodDeliverySystemException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Info Input Parameters -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new FoodDeliverySystemException(400, e.getMessage());
		}

	}
	@AfterReturning(pointcut = "execution(*  com.cg.fooddelivery.service.impl.AdminService..*(..))", returning = "result")
	public void serviceSetterMethodLogging(JoinPoint joint, Object result) throws FoodDeliverySystemException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			slf4jLogger.info("Info Output Parameters -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new FoodDeliverySystemException(400, e.getMessage());
		}
	}
	
	@Before("execution(* com.cg.fooddelivery.service.impl.CustomerService..*(..))")
	public void CustomerLogging(JoinPoint joint) throws FoodDeliverySystemException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Info Input Parameters -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new FoodDeliverySystemException(400, e.getMessage());
		}

	}
	
	@AfterReturning(pointcut = "execution(*  com.cg.fooddelivery.service.impl.CustomerService..*(..))", returning = "result")
	public void CustomerserviceSetterMethodLogging(JoinPoint joint, Object result) throws FoodDeliverySystemException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			slf4jLogger.info("Info Output Parameters -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new FoodDeliverySystemException(400, e.getMessage());
		}
	}
	
	@Before("execution(* com.cg.fooddelivery.service.impl.RestaurantOwnerService..*(..))")
	public void RestaurantOwnerLogging(JoinPoint joint) throws FoodDeliverySystemException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Info Input Parameters -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new FoodDeliverySystemException(400, e.getMessage());
		}

	}
	
	@AfterReturning(pointcut = "execution(*  com.cg.fooddelivery.service.impl.RestaurantOwnerService..*(..))", returning = "result")
	public void RestaurantOwnerserviceSetterMethodLogging(JoinPoint joint, Object result) throws FoodDeliverySystemException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			slf4jLogger.info("Info Output Parameters -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new FoodDeliverySystemException(400, e.getMessage());
		}
	}
}
