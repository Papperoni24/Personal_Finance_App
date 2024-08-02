package com.papperoni.services.impl;

import com.papperoni.models.AccountType;
import com.papperoni.repositories.AccountTypeRepo;
import com.papperoni.services.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {

    private final AccountTypeRepo accountTypeRepo;

    @Autowired
    public AccountTypeServiceImpl(AccountTypeRepo accountTypeRepo) {
        this.accountTypeRepo = accountTypeRepo;
    }

    @Override
    public AccountType saveAccountType(AccountType accountType) {
        return accountTypeRepo.save(accountType);
    }

    @Override
    public Optional<AccountType> getAccountTypeById(int id) {
        return accountTypeRepo.findById(id);
    }

    @Override
    public List<AccountType> getAllAccountTypes() {
        return accountTypeRepo.findAll();
    }

    @Override
    public void deleteAccountType(int id) {
        accountTypeRepo.deleteById(id);
    }
}

