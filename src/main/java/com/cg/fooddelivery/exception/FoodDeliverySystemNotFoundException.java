package com.cg.fooddelivery.exception;

public class FoodDeliverySystemNotFoundException extends RuntimeException{

	
	//private static final long serialVersionUID = 1L;
	
	public FoodDeliverySystemNotFoundException(int adminId) {
		super(" Id not found : " + adminId);
	}

}
