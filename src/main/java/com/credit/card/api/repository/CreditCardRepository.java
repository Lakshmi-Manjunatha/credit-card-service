package com.credit.card.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.credit.card.api.dao.CreditCardEntity;

public interface CreditCardRepository extends CrudRepository<CreditCardEntity, Integer> {

}
