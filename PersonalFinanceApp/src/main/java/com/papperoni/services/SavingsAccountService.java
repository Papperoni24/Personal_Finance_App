package com.papperoni.services;

import com.papperoni.models.SavingsAccount;

import java.util.List;
import java.util.Optional;

public interface SavingsAccountService {

    List<SavingsAccount> getAllSavingsAccounts();

    Optional<SavingsAccount> getSavingsAccountById(Long id);

    SavingsAccount saveSavingsAccount(SavingsAccount savingsAccount);

    void deleteSavingsAccount(Long id);

    SavingsAccount updateSavingsAccount(Long id, SavingsAccount savingsAccountDetails);
}
