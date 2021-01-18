package com.credit.card.api.utils;

public class Constants {

	public static final String CARD_NUMBER_FORMAT = "[0-9]+";
	public static final String VALIDATION_FAILURE = "Validation Failure";
	public static final String CARDNUMBER_INVALID_FORMAT = "Invalid card number, card number should contain only numbers from 0 to 9";
	public static final String CARDNUMBER_LUHN_ERROR = "LUHN Validation error";
	public static final Integer BAD_REQUEST_STATUS = 400;
	public static final String DUPLICATE_NUMBER = "Credit card number already exist !!";
}
