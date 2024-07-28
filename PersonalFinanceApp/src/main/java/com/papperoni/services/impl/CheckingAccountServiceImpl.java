package com.papperoni.services.impl;

import com.papperoni.models.CheckingAccount;
import com.papperoni.repositories.CheckingAccountRepo;
import com.papperoni.services.CheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckingAccountServiceImpl implements CheckingAccountService {

    private final CheckingAccountRepo repository;

    @Autowired
    public CheckingAccountServiceImpl(CheckingAccountRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<CheckingAccount> findAll() {
        return repository.findAll();
    }

    @Override
    public CheckingAccount findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CheckingAccount save(CheckingAccount checkingAccount) {
        return repository.save(checkingAccount);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

