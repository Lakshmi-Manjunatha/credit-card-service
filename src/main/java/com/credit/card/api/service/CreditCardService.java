package com.credit.card.api.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.credit.card.api.dao.CreditCardEntity;
import com.credit.card.api.model.CreditCard;
import com.credit.card.api.repository.CreditCardRepository;

@Service
public class CreditCardService {
	
	
	private ModelMapper modelMapper;
	private CreditCardRepository creditCardRepository;

	public CreditCardService(CreditCardRepository creditCardRepository, ModelMapper modelMapper ) {
		this.creditCardRepository = creditCardRepository;
		this.modelMapper = modelMapper;
	}

	public CreditCard addCreditCardAccount(CreditCard creditcard) throws Exception{
		CreditCardEntity creditCardEntity = modelMapper.map(creditcard, CreditCardEntity.class);
		creditCardRepository.save(creditCardEntity);
		return creditcard;
	}

	public List<CreditCard> fetchCreditCardAccounts() {
		List<CreditCardEntity> cardEntities = creditCardRepository.findAll();
		return Arrays.asList(modelMapper.map(cardEntities, CreditCard[].class));
	}
	
}
