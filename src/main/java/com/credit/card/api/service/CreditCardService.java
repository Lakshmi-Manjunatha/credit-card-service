package com.credit.card.api.service;

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

	public CreditCard addCreditCardAccount(CreditCard creditcard) {
		CreditCardEntity creditCardEntity = modelMapper.map(creditcard, CreditCardEntity.class);
		creditCardRepository.save(creditCardEntity);
		return creditcard;
	}
	
}
