package com.papperoni.services;

import com.papperoni.models.CreditCard;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> findAll();
    CreditCard findById(Long id);
    CreditCard save(CreditCard creditCard);
    void deleteById(Long id);
}
