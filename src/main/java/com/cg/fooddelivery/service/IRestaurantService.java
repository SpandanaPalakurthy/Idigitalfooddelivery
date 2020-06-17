package com.cg.fooddelivery.service;

import java.util.List;
import java.util.Optional;

import com.cg.fooddelivery.model.RestaurantItem;

public interface IRestaurantService {

	RestaurantItem addFoodItems(RestaurantItem restItem, int restaurantId);
	
	List<RestaurantItem> getFoodItems();
	
	Optional<RestaurantItem> getFoodDetails(int itemId);
	
	RestaurantItem updateFoodItems(RestaurantItem restaurantItem, int itemId);
	

  //  Optional<RestaurantItem> getFoodItemsById(int restaurantId);
	/*List<RestaurantItem> getFoodItemsById(int restaurantId);
	
	boolean ValiadaterestaurantId(int restaurantId);
}*/
}