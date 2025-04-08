package com.mbtc.itg.account.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.mbtc.itg.account.bo.AccountTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDto {
	    
		@NotEmpty
	    private String customerName;
		
		@NotEmpty
	    private String customerMobile;
		
		@NotEmpty
		@Email
	    private String customerEmail;
		
		@NotEmpty
	    private String address1;
	    private String address2;
	    private AccountTypeEnum accountType;

}
