package com.credit.card.api.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.credit.card.api.model.CreditCard;
import com.credit.card.api.model.CreditCardInput;
import com.credit.card.api.model.ValidationError;
import com.credit.card.api.service.CreditCardService;
import com.credit.card.api.utils.CreditCardValidator;

@RestController
@RequestMapping(value="/api/v1/cards")
public class CreditCardController {
	private static final Logger log = LoggerFactory.getLogger(CreditCardController.class); 
	
	private CreditCardValidator cardvalidator;
	private CreditCardService creditCardService;
	
	public CreditCardController(CreditCardValidator cardvalidator, CreditCardService creditCardService){
		this.cardvalidator = cardvalidator;
		this.creditCardService = creditCardService;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public ResponseEntity<Object> addCreditCardAccount(@Validated @RequestBody CreditCardInput creditCardInput){
		log.info("Meta data Information :", creditCardInput.getMetadata().getSource());
		return validateAndAddCreditCardAccount(creditCardInput.getCreditcard());
	}

	private ResponseEntity<Object> validateAndAddCreditCardAccount(CreditCard creditcard) {
		
		ValidationError validationError = cardvalidator.validate(creditcard);
		
		if(validationError != null && validationError.getStatus() == 400){
			return new ResponseEntity<Object>(validationError, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>(creditCardService.addCreditCardAccount(creditcard), HttpStatus.CREATED);
	}
		
}
