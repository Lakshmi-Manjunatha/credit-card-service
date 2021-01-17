package com.credit.card.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreditCardValidationInput {
	private CreditCard creditcard;
	private MetaData source;

}
