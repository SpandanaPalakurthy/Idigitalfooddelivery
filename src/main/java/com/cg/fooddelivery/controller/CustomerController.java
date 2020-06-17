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
import com.cg.fooddelivery.model.Admin;
import com.cg.fooddelivery.model.Customer;
import com.cg.fooddelivery.model.Orders;
import com.cg.fooddelivery.model.Payment;
import com.cg.fooddelivery.model.Restaurant;
import com.cg.fooddelivery.service.impl.CustomerService;
@CrossOrigin
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/** customer registration **/

	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	public Customer addCustomer(@Valid @RequestBody Customer customer) throws FoodDeliverySystemException {
		try {
			return customerService.createCustomer(customer);

		} catch (Exception e) {
			//throw new FoodDeliverySystemException(400, e.getMessage());
	e.printStackTrace();
		}
		return customer;
	}

	/** Customer Login **/
	@RequestMapping(value = "/logincustomer", method = RequestMethod.GET)
	public List<Customer> loggingCustomer(@Valid @RequestParam(required = false) String firstName,
			@RequestParam(required = false) String customerPassword) throws FoodDeliverySystemException {
		try {
			return customerService.loggingCustomer(firstName, customerPassword);
		} catch (Exception e) {
			//throw new FoodDeliverySystemException(204, e.getMessage());
		e.printStackTrace();
		}
		return null;
	}

	/** GET all Customer Details **/
	@RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
	public List<Customer> getCustomerDetails() throws FoodDeliverySystemException {
		try {
			return customerService.getCustomerDetails();
		} catch (Exception e) {
			//throw new FoodDeliverySystemException(204, e.getMessage());
		e.printStackTrace();
		}
		return null;
	}

	/** GET all Restaurant Details **/
	@RequestMapping(value = "/getRestaurants", method = RequestMethod.GET)
	public List<Restaurant> getRestaurantDetails() throws FoodDeliverySystemException {
		try {
			return customerService.getRestaurantDetails();
		} catch (Exception e) {
			//throw new FoodDeliverySystemException(204, e.getMessage());
		e.printStackTrace();
		}
		return null;
	}

	/** search restaurant by restaurantId **/

	@RequestMapping(value = "/getRestaurant/{restaurantId}", method = RequestMethod.GET)
	public Optional<Restaurant> getRestaurantbyId(@PathVariable int restaurantId) throws FoodDeliverySystemException {
		try {
			return customerService.getRestaurantbyId(restaurantId);

		} catch (Exception e) {
			//throw new FoodDeliverySystemException(204, e.getMessage());
		e.printStackTrace();
		}
		return null;
	}

	/** wildCardsearch restaurant by restaurantName **/

	@RequestMapping(value = "/restaurantSearch/{restaurantName}", method = RequestMethod.GET)
	public List<Restaurant> getWildCardSearch(@Valid @PathVariable String restaurantName) throws FoodDeliverySystemException {
		try {
			return customerService.getWildCardSearch(restaurantName);
		} catch (Exception e) {
			//throw new FoodDeliverySystemException(204, e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/** making a order **/

	@RequestMapping(value = "/addorder/{customerId}", method = RequestMethod.POST)
	public Orders createOrder(@Valid @RequestBody Orders orders, @PathVariable int customerId)
			throws FoodDeliverySystemException {
		try {
			return customerService.createOrder(orders, customerId);

		} catch (Exception e) {
			//throw new FoodDeliverySystemException(400, e.getMessage());
			e.printStackTrace();
		}
		return orders;
	}

	/** DELETE a order **/

	@RequestMapping(value = "/orders/{orderId}", method = RequestMethod.DELETE)
	public void deleteOrderDetails(@PathVariable int orderId) throws FoodDeliverySystemException {
		try {
			customerService.deleteFoodItems(orderId);

		} catch (Exception e) {
			//throw new FoodDeliverySystemException(204, e.getMessage());
			e.printStackTrace();
		}
	}

	/** make payment **/

	@RequestMapping(value = "/payment/{orderId}", method = RequestMethod.POST)
	public Payment makepayment(@Valid @RequestBody Payment payment, @PathVariable int orderId)
			throws FoodDeliverySystemException {
		try {
			return customerService.makepayment(payment, orderId);

		} catch (Exception e) {
			//throw new FoodDeliverySystemException(400, e.getMessage());
			e.printStackTrace();
		}
		return payment;
	}
	@RequestMapping(value = "/getPaymentDetails", method = RequestMethod.GET)
	public List<Payment> getPaymentDetails() throws FoodDeliverySystemException {
		try {
			return customerService.getPaymentDetails();
		} catch (Exception e) {
			//throw new FoodDeliverySystemException(204, e.getMessage());
		e.printStackTrace();
		}
		return null;
	}
	
	
	 @RequestMapping(value = "/getOrders/{customerId}", method =RequestMethod.GET)
	  public List<Orders> getOrdersbycustId(@PathVariable int customerId) throws FoodDeliverySystemException { 
		 try { 
			 return customerService.orderHistory(customerId);
	 
	 } catch (Exception e) { 
		 //throw new FoodDeliverySystemException(204,e.getMessage()); 
	 e.printStackTrace(); 
	 } return null;
	 }
	 
	 @RequestMapping(value = "/getcustomerOrders/{orderId}", method =RequestMethod.GET)
	  public Optional<Orders> getOrdersbyorderId(@PathVariable int orderId) throws FoodDeliverySystemException { 
		 try { 
			 return customerService.getOrdersbyorderId(orderId);
	 
	 } catch (Exception e) { 
		 //throw new FoodDeliverySystemException(204,e.getMessage()); 
	 e.printStackTrace(); 
	 } return null;
	 }

	/*
	 * @RequestMapping(value = "/getOrders/{customerId}", method =
	 * RequestMethod.GET) public List<Orders>
	 * getOrdersbycustId(@Valid @RequestParam(required = false) int customerId){
	 * return customerService.getorderhistory(customerId);
	 * 
	 * }
	 */
	/*
	 * @RequestMapping(value = "/getOrders/{customerId}", method =
	 * RequestMethod.GET) public Orders getorderdetails(@PathVariable int
	 * customerId) {
	 * 
	 * return customerService.getorderdetails(customerId); }
	 */
		
}
