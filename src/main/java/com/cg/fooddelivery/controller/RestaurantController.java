package com.cg.fooddelivery.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fooddelivery.exception.FoodDeliverySystemException;
import com.cg.fooddelivery.model.Customer;
import com.cg.fooddelivery.model.Orders;
import com.cg.fooddelivery.model.Restaurant;
import com.cg.fooddelivery.model.RestaurantItem;
import com.cg.fooddelivery.service.impl.RestaurantService;

@CrossOrigin
@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restownerservice;

	/** Create Food Items **/

	@RequestMapping(value = "/addFoodItems/{restaurantId}", method = RequestMethod.POST)
	public RestaurantItem addFoodItems(@Valid @RequestBody RestaurantItem restItem, @PathVariable int restaurantId)
			throws FoodDeliverySystemException {
		try {
			return restownerservice.addFoodItems(restItem, restaurantId);
		} catch (Exception e) {
			// throw new FoodDeliverySystemException(400, e.getMessage());
			e.printStackTrace();
		}
		return restItem;
	}

	/** GET Food Items **/

	@RequestMapping(value = "/getFoodItems", method = RequestMethod.GET)
	public List<RestaurantItem> getfooditems() throws FoodDeliverySystemException {
		try {
			return restownerservice.getFoodItems();
		} catch (Exception e) {
			// throw new FoodDeliverySystemException(204, e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/** GET Food Items by itemId **/
	@RequestMapping(value = "/restaurantItems/{itemId}", method = RequestMethod.GET)
	public Optional<RestaurantItem> getFoodDetails(@PathVariable int itemId) throws FoodDeliverySystemException {
		try {
			return restownerservice.getFoodDetails(itemId);

		} catch (Exception e) { // throw new FoodDeliverySystemException(204,
			e.getMessage();
			e.printStackTrace();
		}
		return null;
	}


	/** DELETE Food Items **/

	@RequestMapping(value = "/restaurantItems/{itemId}", method = RequestMethod.DELETE)
	public void deleteFoodDetails(@Valid @PathVariable int itemId) throws FoodDeliverySystemException {
		try {
			restownerservice.deleteFoodItems(itemId);

		} catch (Exception e) {
			// throw new FoodDeliverySystemException(400, e.getMessage());
			e.printStackTrace();
		}
	}

	/** UPDATE Food Items **/
	@RequestMapping(value = "/restaurantItems/{itemId}", method = RequestMethod.PUT)
	public RestaurantItem updateItems(@Valid @RequestBody RestaurantItem restaurantItem, @PathVariable int itemId)
			throws FoodDeliverySystemException {
		try {
			return restownerservice.updateFoodItems(restaurantItem, itemId);

		} catch (Exception e) {
			// throw new FoodDeliverySystemException(204, e.getMessage());
			e.printStackTrace();
		}
		return restaurantItem;
	}

	/** update order **/
	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.PUT)
	public Orders updateorder(@Valid @RequestBody Orders orders, @PathVariable int orderId)
			throws FoodDeliverySystemException {
		try {
			return restownerservice.updateOrders(orders, orderId);
		} catch (Exception e) {
			// throw new FoodDeliverySystemException(400, e.getMessage());
			e.printStackTrace();
		}
		return orders;
	}	
	
	

	/** GET Food Items by itemId **/
	@RequestMapping(value = "/getfooditems/{restaurantId}", method = RequestMethod.GET)
	public List<RestaurantItem> getFoodDetailsbyrestId(@PathVariable int restaurantId) throws FoodDeliverySystemException {
		try {
			return restownerservice.getFoodDetailsbyrestId(restaurantId);

		} catch (Exception e) { // throw new FoodDeliverySystemException(204,
			e.getMessage();
			e.printStackTrace();
		}
		return null;
	}

	
}
