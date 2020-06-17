package com.cg.fooddelivery.service;

import java.util.List;
import java.util.Optional;

import com.cg.fooddelivery.model.Customer;
import com.cg.fooddelivery.model.Orders;
import com.cg.fooddelivery.model.Payment;
import com.cg.fooddelivery.model.Restaurant;

public interface ICustomerService {

	Customer createCustomer(Customer customer);
	Optional<Restaurant> getRestaurantbyId(int restaurantId);

    List<Restaurant> getWildCardSearch(String restaurantName);

    Orders createOrder(Orders orders, int customerId);

    Payment makepayment(Payment payment, int orderId);

    void deleteFoodItems(int orderId);
    
    List<Customer> getCustomerDetails();
    
    List<Restaurant> getRestaurantDetails();
    
    List<Customer> loggingCustomer(String firstName, String customerPassword);
    
    Optional<Orders> getOrdersbyorderId(int orderId);
}
