package com.cg.fooddelivery.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fooddelivery.exception.FoodDeliverySystemException;
import com.cg.fooddelivery.model.Admin;
import com.cg.fooddelivery.model.Restaurant;
import com.cg.fooddelivery.service.IAdminService;
@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	private IAdminService adminService;

	@GetMapping("/test")
	public String testMethod() {
		return "Request is reached";

	}

	/** Admin registeration **/

	@RequestMapping(value = "/addadmin", method = RequestMethod.POST)
	public Admin addAdmin(@Valid @RequestBody Admin admin) throws FoodDeliverySystemException {
		System.out.println("inadd Admin Method ");
		try {
			return adminService.addAdmin(admin);
		} catch (Exception e) {
			//throw new FoodDeliverySystemException(400, e.getMessage());
			e.printStackTrace();
		}
		return admin;
	}

	/** admin Login **/
	@RequestMapping(value = "/loginadmin", method = RequestMethod.GET)
	public List <Admin> loggingAdmin(@Valid @RequestParam(required = false) String adminUsername,
			@RequestParam(required = false) String adminPassword) {
		return adminService.loggingAdmin(adminUsername, adminPassword);
	}
	
	
	/** Admin add Restaurants **/

	@RequestMapping(value = "/addRestaurant/{adminId}", method = RequestMethod.POST)
	public Restaurant addRestaurant(@Valid @RequestBody Restaurant restaurant, @PathVariable int adminId)
			throws FoodDeliverySystemException {
		try {
			return adminService.addRestaurant(restaurant, adminId);

		} catch (Exception e) {
		//	throw new FoodDeliverySystemException(400, e.getMessage());
			e.printStackTrace();
		}
		return restaurant;

	}

	/** GET Admin details ById **/
	@RequestMapping(value = "/getAdmin/{adminId}", method = RequestMethod.GET)
	public Optional<Admin> getAdminDetails(@PathVariable int adminId) throws FoodDeliverySystemException {
		try {
			return adminService.getAdminDetails(adminId);
		} catch (Exception e) {
		//	throw new FoodDeliverySystemException(204, e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/** GET all Admin Details **/
	@RequestMapping(value = "/getAdmins", method = RequestMethod.GET)
	public List<Admin> getAdmins() throws FoodDeliverySystemException {
		try {
			return adminService.getAdmins();
		} catch (Exception e) {
		//	throw new FoodDeliverySystemException(204, e.getMessage());
		e.printStackTrace();
		}
		return null;
	}
}
