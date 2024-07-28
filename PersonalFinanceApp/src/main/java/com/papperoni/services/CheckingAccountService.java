package com.papperoni.services;

import com.papperoni.models.CheckingAccount;

import java.util.List;

public interface CheckingAccountService {
    List<CheckingAccount> findAll();
    CheckingAccount findById(Long id);
    CheckingAccount save(CheckingAccount checkingAccount);
    void deleteById(Long id);
}

