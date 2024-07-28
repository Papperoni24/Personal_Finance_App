package com.papperoni.services.impl;

import com.papperoni.models.CreditCard;
import com.papperoni.repositories.CreditCardRepo;
import com.papperoni.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepo repository;

    @Autowired
    public CreditCardServiceImpl(CreditCardRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<CreditCard> findAll() {
        return repository.findAll();
    }

    @Override
    public CreditCard findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CreditCard save(CreditCard creditCard) {
        return repository.save(creditCard);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
