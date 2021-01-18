package com.credit.card.api.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreditCard {
	
	private String cardHolderName;
	private String cardNumber;
	private BigDecimal balance;
	private Integer creditLimit;
	
}
