package com.mbtc.itg.account.service;

import com.mbtc.itg.account.bo.Customer;
import com.mbtc.itg.account.dto.CustomerRequestDto;

public interface CustomerService {
	
	Customer getCustomer(Long customerNumber);
	
	Customer addCustomer(CustomerRequestDto customerRequestDto);
}
