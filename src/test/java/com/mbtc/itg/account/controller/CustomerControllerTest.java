package com.mbtc.itg.account.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.mbtc.itg.account.bo.AccountTypeEnum;
import com.mbtc.itg.account.bo.Customer;
import com.mbtc.itg.account.dto.CustomResponseDto;
import com.mbtc.itg.account.dto.CustomerRequestDto;
import com.mbtc.itg.account.service.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
	
	@InjectMocks
	CustomerController customerControllerTest;
	
	@Mock
	CustomerService customerService;
	
	@Test
	void getCustomer_Success() {
		
		Mockito.when(customerService.getCustomer(Mockito.anyLong())).thenReturn(createCustomer());
		
		ResponseEntity<CustomResponseDto> response = (ResponseEntity<CustomResponseDto>) customerControllerTest.getCustomer(123L);
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		
	}
	
	@Test
	void getCustomer_Failed() {
		
		Mockito.when(customerService.getCustomer(Mockito.anyLong())).thenReturn(null);
		
		ResponseEntity<CustomResponseDto> response = (ResponseEntity<CustomResponseDto>) customerControllerTest.getCustomer(123L);
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		
	}
	
	
	@Test
	void addCustomer_Success() {
		
		Mockito.when(customerService.addCustomer(Mockito.any())).thenReturn(createCustomer());
		
		ResponseEntity<CustomResponseDto> response = (ResponseEntity<CustomResponseDto>) customerControllerTest.addCustomer(createCustomerRequestDto());
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals("123", response.getBody().getCustomerNumber());
		
	}
	
	@Test
	void addCustomer_Failed() {
		
		Mockito.when(customerService.addCustomer(Mockito.any())).thenReturn(null);
		
		ResponseEntity<CustomResponseDto> response = (ResponseEntity<CustomResponseDto>) customerControllerTest.addCustomer(createCustomerRequestDto());
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		
	}
	
	private CustomerRequestDto createCustomerRequestDto() {
		
		CustomerRequestDto customerRequestDto = new CustomerRequestDto();
		customerRequestDto.setCustomerName("Test");
		customerRequestDto.setCustomerMobile("6391812345678");
		customerRequestDto.setCustomerEmail("test@gmail.com");
		customerRequestDto.setAddress1("Address City");
		customerRequestDto.setAddress2("");
		customerRequestDto.setAccountType(AccountTypeEnum.CHECKING);
		
		return customerRequestDto;
	}
	
	
	
	private Customer createCustomer() {
		
		Customer customer = new Customer();
		customer.setCustomerNumber(123L);
		customer.setCustomerName("Test");
		customer.setCustomerMobile("6391812345678");
		customer.setCustomerEmail("test@gmail.com");
		customer.setAddress1("Address City");
		customer.setAddress2("");
		customer.setAccountType(AccountTypeEnum.CHECKING);
		
		return customer;
	}

}
