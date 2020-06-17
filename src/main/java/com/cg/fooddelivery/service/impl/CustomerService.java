package com.cg.fooddelivery.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.fooddelivery.model.Admin;
import com.cg.fooddelivery.model.Customer;
import com.cg.fooddelivery.model.Orders;
import com.cg.fooddelivery.model.Payment;
import com.cg.fooddelivery.model.Restaurant;
import com.cg.fooddelivery.repository.CustomerRepository;
import com.cg.fooddelivery.repository.OrdersRepository;
import com.cg.fooddelivery.repository.PaymentRepository;
import com.cg.fooddelivery.repository.RestaurantRepository;
import com.cg.fooddelivery.service.ICustomerService;

@Service
@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	private RestaurantRepository restaruntRepository;
	@Autowired

	private CustomerRepository customerRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Optional<Restaurant> getRestaurantbyId(int restaurantId) {
		return restaruntRepository.findById(restaurantId);
	}

	public List<Restaurant> getWildCardSearch(String restaurantName) {
		if (ValiadaterestaurantName(restaurantName))

			return restaruntRepository.getDetails(restaurantName);
		else
			return null;
	}

	private boolean ValiadaterestaurantName(String restaurantName) {
		List<Restaurant> restaurant = restaruntRepository.getDetails(restaurantName);

		if (restaurant != null)
			return true;
		else
			return false;

	}

	public Orders createOrder(Orders orders, int customerId) {

		 Customer customer = customerRepository.getOne(customerId);
		 System.out.println(customerId);
		 orders.setOrderCustomer(customer);
		return ordersRepository.save(orders);
	}

	public Payment makepayment(Payment payment, int orderId) {
		Orders order = ordersRepository.getOne(orderId);
		System.out.println("orderId...." + orderId);
		payment.setPaymentOrder(order);
		return paymentRepository.save(payment);
	}

	public void deleteFoodItems(int orderId) {
		ordersRepository.deleteById(orderId);

	}

	public List<Customer> getCustomerDetails() {
		return customerRepository.findAll();
	}

	public List<Restaurant> getRestaurantDetails() {
		return restaruntRepository.findAll();
	}

	
	public List<Customer> loggingCustomer(String firstName, String customerPassword) {
		// TODO Auto-generated method stub
		return customerRepository.findDetails(firstName,customerPassword);
	}

	public List<Payment> getPaymentDetails() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	

	public List<Orders> orderHistory(int customerId) { 
		return ordersRepository.findAll();
		}

	public Optional<Orders> getOrdersbyorderId(int orderId) {
		// TODO Auto-generated method stub
		return ordersRepository.findById(orderId);
	}

	
	}

	/*
	 * public Orders getorderdetails(int customerId) { if
	 * (ValiadatecustomerId(customerId)) return ordersRepository.getOne(customerId);
	 * else return null; }
	 * 
	 * private boolean ValiadatecustomerId(int customerId) { Optional<Orders> orders
	 * = ordersRepository.findById(customerId); if (orders != null) return true;
	 * else return false; } }
	 */
	 
	/*
	 * public List<Orders> getorderhistory(@Valid int customerId) { // TODO
	 * Auto-generated method stub return
	 * ordersRepository.findorderdetails(customerId); }
	 * 
	 * 
	 * 
	 */

