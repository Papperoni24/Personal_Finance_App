package com.papperoni.services.impl;

import com.papperoni.models.OtherDepositAccount;
import com.papperoni.repositories.OtherDepositAccountRepo;
import com.papperoni.services.OtherDepositAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OtherDepositAccountServiceImpl implements OtherDepositAccountService {

    private final OtherDepositAccountRepo otherDepositAccountRepo;

    @Autowired
    public OtherDepositAccountServiceImpl(OtherDepositAccountRepo otherDepositAccountRepo) {
        this.otherDepositAccountRepo = otherDepositAccountRepo;
    }

    @Override
    public List<OtherDepositAccount> getAllOtherDepositAccounts() {
        return otherDepositAccountRepo.findAll();
    }

    @Override
    public Optional<OtherDepositAccount> getOtherDepositAccountById(Long id) {
        return otherDepositAccountRepo.findById(id);
    }

    @Override
    public OtherDepositAccount saveOtherDepositAccount(OtherDepositAccount otherDepositAccount) {
        return otherDepositAccountRepo.save(otherDepositAccount);
    }

    @Override
    public void deleteOtherDepositAccount(Long id) {
        otherDepositAccountRepo.deleteById(id);
    }

    @Override
    public OtherDepositAccount updateOtherDepositAccount(Long id, OtherDepositAccount otherDepositAccountDetails) {
        OtherDepositAccount existingAccount = otherDepositAccountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("OtherDepositAccount not found"));

        existingAccount.setAccountIdentifier(otherDepositAccountDetails.getAccountIdentifier());
        existingAccount.setAccountName(otherDepositAccountDetails.getAccountName());
        existingAccount.setBalance(otherDepositAccountDetails.getBalance());
        existingAccount.setCreatedAt(otherDepositAccountDetails.getCreatedAt());
        existingAccount.setNotes(otherDepositAccountDetails.getNotes());
        existingAccount.setOwnerID(otherDepositAccountDetails.getOwnerID());

        return otherDepositAccountRepo.save(existingAccount);
    }
}
