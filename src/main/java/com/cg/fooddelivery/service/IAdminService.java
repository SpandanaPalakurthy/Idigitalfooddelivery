package com.cg.fooddelivery.service;

import java.util.List;
import java.util.Optional;

import com.cg.fooddelivery.model.Admin;
import com.cg.fooddelivery.model.Restaurant;

public interface IAdminService {

	Admin addAdmin(Admin admin);

	Restaurant addRestaurant(Restaurant restaurant, int adminId);

	Optional<Admin> getAdminDetails(int adminId);

	List<Admin> getAdmins();

	List<Admin> loggingAdmin(String adminUsername, String adminPassword);

	//List<Admin> loggingAdmin(String adminUsername, String adminPassword);

}
