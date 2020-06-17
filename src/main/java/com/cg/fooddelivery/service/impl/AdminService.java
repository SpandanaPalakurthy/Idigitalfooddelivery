package com.cg.fooddelivery.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.fooddelivery.model.Admin;
import com.cg.fooddelivery.model.Restaurant;
import com.cg.fooddelivery.repository.AdminRepository;
import com.cg.fooddelivery.repository.RestaurantRepository;
import com.cg.fooddelivery.service.IAdminService;

@Service
@Transactional
public class AdminService implements IAdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private RestaurantRepository restaruntRepository;

	public Admin addAdmin(Admin admin) {

		return adminRepository.save(admin);
	}

	//@Override
	public Restaurant addRestaurant(Restaurant restaurant, int adminId) {
		Admin admin = adminRepository.getOne(adminId);
		System.out.println("admin Id...." + adminId);
		restaurant.setAdmin(admin);
		System.out.println("resturant...." + restaurant);
		return restaruntRepository.save(restaurant);
	}

	//@Override
	public Optional<Admin> getAdminDetails(int adminId) {

		return adminRepository.findById(adminId);
	}

	//@Override
	public List<Admin> getAdmins() {
		return adminRepository.findAll();
	}

	//@Override
	public List<Admin> loggingAdmin(String adminUsername, String adminPassword) {
		// TODO Auto-generated method stub
		return adminRepository.findDetails(adminUsername,adminPassword);
	}

}
