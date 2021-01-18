package com.credit.card.api.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.credit.card.api.utils.CreditCardValidator;

@Component
public class MockBeanConfig {
	
	@Bean
	public CreditCardValidator creditCardValidatorBean() {
		return new CreditCardValidator();
	}

}
