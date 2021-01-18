package com.credit.card.api.model;

import lombok.Data;

@Data
public class CreditCard {
	
	private String cardHolderName;
	private String cardNumber;
	private Boolean balance;
	private Integer creditLimit;
	
}
