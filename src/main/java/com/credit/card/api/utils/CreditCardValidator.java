package com.credit.card.api.utils;

import static com.credit.card.api.utils.Constants.*;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.credit.card.api.model.CreditCard;
import com.credit.card.api.model.ValidationError;

@Component
public class CreditCardValidator {

	public ValidationError validate(CreditCard creditcard) {
		
		return isValidCreditCardNumber(creditcard.getCardNumber());
	}
	
	private ValidationError isValidCreditCardNumber(String cardNumber){
		if(cardNumber == null || cardNumber.length() > 19
				||  !cardNumber.matches(CARD_NUMBER_FORMAT)){
			
			return new ValidationError(BAD_REQUEST_STATUS, LocalDateTime.now(), VALIDATION_FAILURE, CARDNUMBER_INVALID_FORMAT);
		}
		if(!luhnValidation(cardNumber)) {
			return new ValidationError(BAD_REQUEST_STATUS, LocalDateTime.now(), VALIDATION_FAILURE, CARDNUMBER_LUHN_ERROR);
		}
		return new ValidationError();
	}

	private boolean luhnValidation(String cardNumber) {
		int[] a = {cardNumber.length() % 2 == 0 ? 1 : 2}; 
		return cardNumber.chars().map(i -> i - '0')
		.map(n -> n * (a[0] = a[0] == 1 ? 2 : 1))
		.map(n -> n > 9 ? n - 9 : n)
		.sum() % 10 == 0;	
	}

}
