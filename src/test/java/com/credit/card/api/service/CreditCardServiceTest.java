package com.credit.card.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import com.credit.card.api.dao.CreditCardEntity;
import com.credit.card.api.model.CreditCard;
import com.credit.card.api.repository.CreditCardRepository;

class CreditCardServiceTest {

	 private CreditCardRepository cardRepository = Mockito.mock(CreditCardRepository.class);
	 private CreditCardService creditCardService  = new CreditCardService(cardRepository, new ModelMapper());

	@Test
	public void when_save_creditCard_it_should_return_creditCard(){
		CreditCard creditCard = new CreditCard();
		creditCard.setCardNumber("34567890543");
		creditCard.setCardHolderName("CardHolderName");
		creditCard.setCreditLimit(2000);
		creditCard.setBalance(BigDecimal.ZERO);
		Mockito.when(cardRepository.save(Mockito.any(CreditCardEntity.class))).thenReturn(new CreditCardEntity());
		assertEquals("34567890543", creditCardService.addCreditCardAccount(creditCard).getCardNumber());
	}
	
	@Test
	public void when_save_creditCard_it_should_set_balanceTo_Zero(){
		CreditCard creditCard = new CreditCard();
		creditCard.setCardNumber("34567890543");
		creditCard.setCardHolderName("CardHolderName");
		creditCard.setCreditLimit(2000);
		creditCard.setBalance(BigDecimal.ZERO);
		Mockito.when(cardRepository.save(Mockito.any(CreditCardEntity.class))).thenReturn(new CreditCardEntity());
		assertEquals(BigDecimal.ZERO, creditCardService.addCreditCardAccount(creditCard).getBalance());
	}
	
}
