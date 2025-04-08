package com.mbtc.itg.account.exception;

public class CustomerException  extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CustomerException(String message) {
	 super(message);
	}
	
	public CustomerException(Throwable cause) {
		 super(cause);
	}
	
	public CustomerException(String message, Throwable cause) {
		 super(message);
	}

	

}
