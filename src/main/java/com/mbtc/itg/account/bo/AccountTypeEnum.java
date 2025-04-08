package com.mbtc.itg.account.bo;

public enum AccountTypeEnum {
	
	SAVINGS("S"), CHECKING("C");
	
	private String description;

	AccountTypeEnum(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static AccountTypeEnum get(String description) {
		for(AccountTypeEnum accountType : AccountTypeEnum.values()) {
			if (accountType.getDescription().equalsIgnoreCase(description)) {
				return accountType;
			}
		}
		return AccountTypeEnum.SAVINGS;
	}
}
