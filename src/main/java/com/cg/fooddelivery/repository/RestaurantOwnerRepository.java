package com.cg.fooddelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fooddelivery.model.Restaurant;
import com.cg.fooddelivery.model.RestaurantItem;

@Repository
public interface RestaurantOwnerRepository extends JpaRepository<RestaurantItem, Integer>{

	
	/*
	 * @Query("select n from RestaurantItem n where n.restaurantName=:restaurantName "
	 * ) List<RestaurantItem> findfooditems(@Param(value = "restaurantName") String
	 * restaurantName);
	 */
	
	
	

	

	
	
	
	
	
	

}
