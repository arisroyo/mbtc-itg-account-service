package com.mbtc.itg.account.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
	
	public Customer() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_number")
    private Long customerNumber;
    
    @NotBlank(message = "Name is required field")
    @Column(name = "customer_name")
    private String customerName;
    
    @NotBlank(message = "Mobile is required field")
    @Column(name = "customer_mobile")
    private String customerMobile;
    
    @Email(message = "Invalid Email format")
    @NotBlank(message = "Email is required field")
    @Column(name = "customer_email")
    private String customerEmail;
    
    @NotBlank(message = "address1 is required field")
    @Column(name = "address1")
    private String address1;
    
    @Column(name = "address2")
    private String address2;
    
    @Column(name = "account_type")
    private AccountTypeEnum accountType;
    
    
    public Customer(String customerName, String customerMobile, String customerEmail, String address1,
    		String address2, AccountTypeEnum accountType) {
    
    	this.customerName = customerName;
    	this.customerMobile = customerMobile;
    	this.customerEmail = customerEmail;
    	this.address1 = address1;
    	this.address2 = address2;
    	this.accountType = accountType;
    	
    }

}