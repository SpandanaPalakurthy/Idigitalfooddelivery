package com.cg.fooddelivery.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.fooddelivery.model.Orders;
import com.cg.fooddelivery.model.Restaurant;
import com.cg.fooddelivery.model.RestaurantItem;
import com.cg.fooddelivery.repository.OrdersRepository;
import com.cg.fooddelivery.repository.RestaurantOwnerRepository;
import com.cg.fooddelivery.repository.RestaurantRepository;
import com.cg.fooddelivery.service.IRestaurantService;

@Service
@Transactional
public class RestaurantService implements IRestaurantService {

	@Autowired
	private RestaurantOwnerRepository restOwnerRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;


	public RestaurantItem addFoodItems(RestaurantItem restItem, int restaurantId) {
		Restaurant restaurant = restaurantRepository.getOne(restaurantId);
		System.out.println("restId..."+ restaurantId);
		restItem.setRestaurant(restaurant);
		return restOwnerRepository.save(restItem);
	}

	public List<RestaurantItem> getFoodItems() {
		return restOwnerRepository.findAll();
	}

	public Optional<RestaurantItem> getFoodDetails(int itemId) {

		return restOwnerRepository.findById(itemId);
	}

	public void deleteFoodItems(int itemId) {
		restOwnerRepository.deleteById(itemId);

	}

	public RestaurantItem updateFoodItems(RestaurantItem restaurantItem, int itemId) {

		RestaurantItem existingItem = restOwnerRepository.getOne(itemId);
		existingItem.setItemname(restaurantItem.getItemname());
		existingItem.setItemdescription(restaurantItem.getItemdescription());
		existingItem.setItemPrice(restaurantItem.getItemPrice());
		return restOwnerRepository.save(existingItem);
	}
	
	public Orders updateOrders(Orders orders, int orderId) {
		Orders existingOrder = ordersRepository.getOne(orderId);
		existingOrder.setOrderStatus(orders.getOrderStatus());
		existingOrder.setOrderDate(orders.getOrderDate());
		existingOrder.setOrderPayment(orders.getOrderPayment());
			return ordersRepository.save(existingOrder);
		}

		/*
		 * public List<RestaurantItem> getfooditems(String restaurantName) { // TODO
		 * Auto-generated method stub return
		 * restOwnerRepository.findfooditems(restaurantName); }
		 */

	public List<RestaurantItem> getFoodDetailsbyrestId(int restaurantId) {
		// TODO Auto-generated method stub
		return restOwnerRepository.findAll();
	}

	
		


	

	

		
		/*
		 * public List<RestaurantItem> getFoodItemsById(int restaurantId){ if
		 * (ValiadaterestaurantId(restaurantId))
		 * 
		 * return restOwnerRepository.getfooddetails(restaurantId); else return null; }
		 * 
		 * public boolean ValiadaterestaurantId(int restaurantId) { List<RestaurantItem>
		 * restaurantItem = restOwnerRepository.getfooddetails(restaurantId);
		 * 
		 * if (restaurantItem != null) return true; else return false;
		 * 
		 * }
		 */

	}


		

