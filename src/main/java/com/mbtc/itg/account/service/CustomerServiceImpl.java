package com.mbtc.itg.account.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbtc.itg.account.bo.Customer;
import com.mbtc.itg.account.dto.CustomerRequestDto;
import com.mbtc.itg.account.exception.CustomerException;
import com.mbtc.itg.account.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer getCustomer(Long customerNumber) {
		return  customerRepository.findBycustomerNumber(customerNumber);
	}

	@Override
	public Customer addCustomer(CustomerRequestDto customerRequestDto) {
		
		try {
			Customer customer  = customerRepository.save(new Customer(customerRequestDto.getCustomerName(),
				customerRequestDto.getCustomerMobile(),
				customerRequestDto.getCustomerEmail(),
				customerRequestDto.getAddress1(),
				customerRequestDto.getAddress2(),
				customerRequestDto.getAccountType()
				));
			
			return customer;
		} catch (ConstraintViolationException consEx) {
			
			  List<String> errorMessages = consEx.getConstraintViolations()
			            .stream()
			            .map(ConstraintViolation::getMessage)
			            .collect(Collectors.toList());
			  
			throw new CustomerException(errorMessages.get(0).toString());
		}
		
		
	}

}
