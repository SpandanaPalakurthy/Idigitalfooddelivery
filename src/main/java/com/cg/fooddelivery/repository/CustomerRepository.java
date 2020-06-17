package com.cg.fooddelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.fooddelivery.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT c from Customer c where c.firstName=:firstName and c.customerPassword=:customerPassword")

	List<Customer> findDetails(@Param(value = "firstName") String firstName,
			@Param(value ="customerPassword") String customerPassword );

	
	
	
	

}
