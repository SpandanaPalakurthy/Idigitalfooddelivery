package com.cg.fooddelivery.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fooddelivery.model.Customer;
import com.cg.fooddelivery.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	

	
	/*
	 * @Query("SELECT o from Orders o where o.customerId=:customerId") List<Orders>
	 * findorderdetails(@Param(value = "customerId")@Valid int customerId);
	 * 
	 * 
	 */
	
}
