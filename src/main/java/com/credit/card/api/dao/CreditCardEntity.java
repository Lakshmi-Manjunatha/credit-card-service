package com.credit.card.api.dao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "credit_card")
@Data
public class CreditCardEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String cardHolderName;
	
	@Column(unique = true)
	private String cardNumber;
	
	@Column
	private BigDecimal balance;
	
	@Column
	private Integer creditLimit;

}
