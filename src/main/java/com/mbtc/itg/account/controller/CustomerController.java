package com.mbtc.itg.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbtc.itg.account.bo.Customer;
import com.mbtc.itg.account.config.ApplicationConstant;
import com.mbtc.itg.account.dto.CustomResponseDto;
import com.mbtc.itg.account.dto.CustomerRequestDto;
import com.mbtc.itg.account.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(value = "/account/{customerNumber}")
    public HttpEntity<CustomResponseDto> getCustomer(@PathVariable Long customerNumber) {
		try {
			Customer customer = customerService.getCustomer(customerNumber);
			CustomResponseDto customResponseDto = new CustomResponseDto(customer, ApplicationConstant.CUSTOMER_NUMERIC_FOUND, 
					ApplicationConstant.CUSTOMER_ACCOUNT_FOUND);
			return ResponseEntity.status(HttpStatus.FOUND).contentType(MediaType.APPLICATION_JSON).body(customResponseDto);
		} catch (Exception ex) {
			CustomResponseDto customResponseDto = new CustomResponseDto(ApplicationConstant.CUSTOMER_NUMERIC_NOT_FOUND, 
					ApplicationConstant.CUSTOMER_NOT_FOUND);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(customResponseDto);
		}
	}

    @PostMapping(value = "/account")
    public HttpEntity<CustomResponseDto> addCustomer(@RequestBody CustomerRequestDto request) {
	
		try {
			
			Customer customer = customerService.addCustomer(request);
			CustomResponseDto customResponseDto = new CustomResponseDto(customer.getCustomerNumber(), ApplicationConstant.CUSTOMER_NUMERIC_ACCOUNT_CREATED, 
					ApplicationConstant.CUSTOMER_ACCOUNT_CREATED);
			return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(customResponseDto);
			
		} catch (Exception ex) {
			CustomResponseDto customResponseDto = new CustomResponseDto(ApplicationConstant.CUSTOMER_NUMERIC_BADREQUEST, 
					ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(customResponseDto);
		}
    }
    
}
