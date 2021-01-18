package com.credit.card.api.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.credit.card.api.model.ValidationError;
import com.credit.card.api.utils.Constants;

@ControllerAdvice
public class CreditCardExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ConstraintViolationException.class)
	   protected ResponseEntity<Object> handleConstraintViolation(
			   ConstraintViolationException ex) {
			ValidationError apiError = new ValidationError();
	       apiError.setMessage(Constants.VALIDATION_FAILURE);
	       apiError.setStatus(Constants.BAD_REQUEST_STATUS);
	       apiError.setDebugMessage(Constants.DUPLICATE_NUMBER);
	       return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	   }

}
