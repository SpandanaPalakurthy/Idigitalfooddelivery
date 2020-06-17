/**
 * 
 */
package com.cg.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fooddelivery.model.Restaurant;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	@Query("select a from Restaurant a where a.restaurantName Like  %:restName%")
	List<Restaurant> getDetails(@Param(value="restName") String restaurantName);
	

}
