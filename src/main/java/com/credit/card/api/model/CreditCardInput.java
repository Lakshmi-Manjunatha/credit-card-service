package com.credit.card.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreditCardInput {
	private CreditCard creditcard;
	private Metadata metadata;

}
