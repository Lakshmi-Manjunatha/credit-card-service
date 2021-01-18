package com.credit.card.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
	public void when_save_creditCard_it_should_return_creditCard() throws Exception{
		CreditCard creditCard = new CreditCard();
		creditCard.setCardNumber("34567890543");
		creditCard.setCardHolderName("CardHolderName");
		creditCard.setCreditLimit(2000);
		creditCard.setBalance(BigDecimal.ZERO);
		Mockito.when(cardRepository.save(Mockito.any(CreditCardEntity.class))).thenReturn(new CreditCardEntity());
		assertEquals("34567890543", creditCardService.addCreditCardAccount(creditCard).getCardNumber());
	}
	
	@Test
	public void when_save_creditCard_it_should_set_balanceTo_Zero() throws Exception{
		CreditCard creditCard = new CreditCard();
		creditCard.setCardNumber("34567890543");
		creditCard.setCardHolderName("CardHolderName");
		creditCard.setCreditLimit(2000);
		creditCard.setBalance(BigDecimal.ZERO);
		Mockito.when(cardRepository.save(Mockito.any(CreditCardEntity.class))).thenReturn(new CreditCardEntity());
		assertEquals(BigDecimal.ZERO, creditCardService.addCreditCardAccount(creditCard).getBalance());
	}	
	
	
	@Test
	public void when_fetch_it_should_return_creditCardAccounts() throws Exception{
		List<CreditCardEntity> cardEntities = new ArrayList<>();
		CreditCardEntity creditCard = new CreditCardEntity();
		creditCard.setCardNumber("34567890543");
		creditCard.setCardHolderName("CardHolderName");
		creditCard.setCreditLimit(2000);
		creditCard.setBalance(BigDecimal.ZERO);
		creditCard.setId(1);
		cardEntities.add(creditCard);
		Mockito.when(cardRepository.findAll()).thenReturn(cardEntities);
		assertEquals(false, creditCardService.fetchCreditCardAccounts().isEmpty());
	}
	
	@Test
	public void when_fetch_emptyArray_noDataFound() throws Exception{
		List<CreditCardEntity> cardEntities = new ArrayList<>();
		Mockito.when(cardRepository.findAll()).thenReturn(cardEntities);
		assertEquals(true, creditCardService.fetchCreditCardAccounts().isEmpty());
	}
}
