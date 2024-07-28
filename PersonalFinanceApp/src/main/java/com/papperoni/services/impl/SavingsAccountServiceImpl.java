package com.papperoni.services.impl;

import com.papperoni.models.SavingsAccount;
import com.papperoni.repositories.SavingsAccountRepo;
import com.papperoni.services.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

    private final SavingsAccountRepo savingsAccountRepository;

    @Autowired
    public SavingsAccountServiceImpl(SavingsAccountRepo savingsAccountRepository) {
        this.savingsAccountRepository = savingsAccountRepository;
    }

    @Override
    public List<SavingsAccount> getAllSavingsAccounts() {
        return savingsAccountRepository.findAll();
    }

    @Override
    public Optional<SavingsAccount> getSavingsAccountById(Long id) {
        return savingsAccountRepository.findById(id);
    }

    @Override
    public SavingsAccount saveSavingsAccount(SavingsAccount savingsAccount) {
        return savingsAccountRepository.save(savingsAccount);
    }

    @Override
    public void deleteSavingsAccount(Long id) {
        savingsAccountRepository.deleteById(id);
    }

    @Override
    public SavingsAccount updateSavingsAccount(Long id, SavingsAccount savingsAccountDetails) {
        SavingsAccount savingsAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SavingsAccount not found"));

        savingsAccount.setAccountName(savingsAccountDetails.getAccountName());
        savingsAccount.setAccountIdentifier(savingsAccountDetails.getAccountIdentifier());
        savingsAccount.setBalance(savingsAccountDetails.getBalance());
        savingsAccount.setNotes(savingsAccountDetails.getNotes());

        return savingsAccountRepository.save(savingsAccount);
    }
}
