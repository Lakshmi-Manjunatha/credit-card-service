package com.credit.card.api.controller;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.credit.card.api.repository.CreditCardRepository;
import com.credit.card.api.service.CreditCardService;
import com.credit.card.api.utils.CreditCardValidator;

@Component
public class MockBeanConfig {
	
	@Bean
	public CreditCardValidator creditCardValidatorBean() {
		return new CreditCardValidator();
	}
	
	@Bean
	public CreditCardService creditCardServiceBean() {
		return Mockito.mock(CreditCardService.class);
	}
	
	@Bean
	public CreditCardRepository creditCardRepositoryBean() {
		return Mockito.mock(CreditCardRepository.class);
	}

}
