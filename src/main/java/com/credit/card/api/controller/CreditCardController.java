package com.credit.card.api.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<Object> addCreditCardAccount(@RequestBody CreditCardInput creditCardInput) throws Exception{
		log.info("Meta data Information :", creditCardInput.getMetadata().getSource());
		return validateAndAddCreditCardAccount(creditCardInput.getCreditcard());
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public ResponseEntity<List<CreditCard>> getCreditCardAccounts(){
		return new ResponseEntity<List<CreditCard>>(creditCardService.fetchCreditCardAccounts(), HttpStatus.OK);
	}
	
	

	private ResponseEntity<Object> validateAndAddCreditCardAccount(CreditCard creditcard) throws Exception {
		
		ValidationError validationError = cardvalidator.validate(creditcard);
		
		if(validationError != null && validationError.getStatus() == 400){
			return new ResponseEntity<Object>(validationError, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>(creditCardService.addCreditCardAccount(creditcard), HttpStatus.CREATED);
	}
		
}
