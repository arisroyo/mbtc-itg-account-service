package com.mbtc.itg.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbtc.itg.account.bo.Customer;

@Repository
public interface  CustomerRepository  extends JpaRepository<Customer, Long>{
	
	Customer findByCustomerName(String customerName);
	
	Customer findBycustomerNumber(Long customerNumber);
	
}
