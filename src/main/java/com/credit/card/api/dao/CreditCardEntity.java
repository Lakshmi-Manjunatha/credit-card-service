package com.credit.card.api.dao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class CreditCardEntity {
	
	@Id
	@Column
	private int id;
	
	@Column
	private String cardHolderName;
	
	@Column
	private String cardNumber;
	
	@Column
	private BigDecimal balance;
	
	@Column
	private Integer creditLimit;

}
