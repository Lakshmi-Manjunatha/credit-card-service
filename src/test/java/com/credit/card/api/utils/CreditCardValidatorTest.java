package com.credit.card.api.utils;

import static com.credit.card.api.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import com.credit.card.api.model.CreditCard;


public class CreditCardValidatorTest {
	
	private CreditCardValidator cardValidator = new CreditCardValidator();
	private CreditCard creditcard = new CreditCard();
	
	@Test
	public void returnErrorWhenCardNumberIsNull(){
		creditcard.setCardNumber(null);
		assertEquals(CARDNUMBER_INVALID_FORMAT,cardValidator.validate(creditcard).getDebugMessage());
	}
	
	@Test
	public void returnErrorWhenCardNumberLengthIs20(){
		creditcard.setCardNumber("09876543210987654321");
		assertEquals(CARDNUMBER_INVALID_FORMAT,cardValidator.validate(creditcard).getDebugMessage());
	}
	
	@Test
	public void returnErrorWhenCardNumberContainString(){
		creditcard.setCardNumber("3498XX986");
		assertEquals(CARDNUMBER_INVALID_FORMAT,cardValidator.validate(creditcard).getDebugMessage());
	}
	
	@Test
	public void returnErrorWithInValidCardNumber(){
		creditcard.setCardNumber("1358954993914434");
		assertEquals(CARDNUMBER_LUHN_ERROR,cardValidator.validate(creditcard).getDebugMessage());
	}
	
	@Test
	public void returnErrorWithSpaceInCardNumber(){
		creditcard.setCardNumber("135895 4993914435");
		assertEquals(CARDNUMBER_INVALID_FORMAT,cardValidator.validate(creditcard).getDebugMessage());
	}
	
	@Test
	public void noErrorForModuloTenResultToZeroCardNumber(){
		creditcard.setCardNumber("1358954993914435");
		assertEquals(null,cardValidator.validate(creditcard).getDebugMessage());
	}
	
}
