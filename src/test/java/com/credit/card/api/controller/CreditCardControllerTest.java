package com.credit.card.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.credit.card.api.model.CreditCard;
import com.credit.card.api.model.CreditCardInput;
import com.credit.card.api.model.Metadata;
import com.credit.card.api.service.CreditCardService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {CreditCardController.class, MockBeanConfig.class})
public class CreditCardControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private CreditCardService creditCardService;
	
	private Metadata metadata = new Metadata("Test");
	
	CreditCard creditCard = new CreditCard();
		
	@Test
	public void whenValidationError_thenReturn400() throws Exception{
		creditCard.setCardNumber("3456XX23");
		assertEquals(400,callApiAndReturnResponseCode(creditCard));
	}
	

	@Test
	public void whenNoValidationError_thenReturn200() throws Exception{
		creditCard.setCardNumber("1358954993914435");
		assertEquals(201,callApiAndReturnResponseCode(creditCard));
	}
	
	private Object callApiAndReturnResponseCode(CreditCard creditCard) throws Exception {
		Mockito.when(creditCardService.addCreditCardAccount(creditCard)).thenReturn(creditCard);
		CreditCardInput creditCardInput = new CreditCardInput(creditCard, metadata);
		MockHttpServletResponse mockResponse =  mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/cards")
			        .contentType(MediaType.APPLICATION_JSON_VALUE)
			        .content(objectMapper.writeValueAsString(creditCardInput))).andReturn().getResponse();
		return mockResponse.getStatus();
	}

}
