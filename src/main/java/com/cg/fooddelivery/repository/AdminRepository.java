package com.cg.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fooddelivery.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("SELECT e from Admin e where e.adminUsername=:adminUsername and e.adminPassword=:adminPassword")
	List<Admin> findDetails(@Param(value = "adminUsername") String adminUsername, 
			@Param(value ="adminPassword") String adminPassword);

}
