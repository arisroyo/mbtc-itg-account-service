package com.mbtc.itg.account.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mbtc.itg.account.bo.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponseDto {
	
	private Customer customer;
	private String customerNumber;
	private String transactionStatusCode;
	private String transactionStatusDescription;
	private List<Customer> listCustomer;
	
	
	public CustomResponseDto(Customer customer, String transactionStatusCode, String transactionStatusDescription) {
		this.customer = customer;
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}
	
	public CustomResponseDto(Long customerNumber, String transactionStatusCode, String transactionStatusDescription) {
		this.customerNumber = Long.toString(customerNumber);
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}
	
	public CustomResponseDto(Customer customer) {
		this.customerNumber = Long.toString(customer.getCustomerNumber());
	}
	
	public CustomResponseDto(String transactionStatusCode, String transactionStatusDescription) {
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}
	
	public CustomResponseDto(List<Customer> listCustomer) {
		this.listCustomer = listCustomer;
	}
}
