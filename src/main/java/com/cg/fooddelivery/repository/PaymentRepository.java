package com.cg.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.cg.fooddelivery.model.Payment;

@Service
public interface PaymentRepository  extends JpaRepository<Payment, Integer> {

	

}
