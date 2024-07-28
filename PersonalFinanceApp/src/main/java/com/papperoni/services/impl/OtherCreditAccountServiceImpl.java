package com.papperoni.services.impl;

import com.papperoni.models.OtherCreditAccount;
import com.papperoni.repositories.OtherCreditAccountRepo;
import com.papperoni.services.OtherCreditAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OtherCreditAccountServiceImpl implements OtherCreditAccountService {

    private final OtherCreditAccountRepo otherCreditAccountRepository;

    @Autowired
    public OtherCreditAccountServiceImpl(OtherCreditAccountRepo otherCreditAccountRepository) {
        this.otherCreditAccountRepository = otherCreditAccountRepository;
    }

    @Override
    public List<OtherCreditAccount> getAllOtherCreditAccounts() {
        return otherCreditAccountRepository.findAll();
    }

    @Override
    public Optional<OtherCreditAccount> getOtherCreditAccountById(Long id) {
        return otherCreditAccountRepository.findById(id);
    }

    @Override
    public OtherCreditAccount saveOtherCreditAccount(OtherCreditAccount otherCreditAccount) {
        return otherCreditAccountRepository.save(otherCreditAccount);
    }

    @Override
    public void deleteOtherCreditAccount(Long id) {
        otherCreditAccountRepository.deleteById(id);
    }

    @Override
    public OtherCreditAccount updateOtherCreditAccount(Long id, OtherCreditAccount otherCreditAccountDetails) {
        OtherCreditAccount otherCreditAccount = otherCreditAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OtherCreditAccount not found"));

        otherCreditAccount.setOwner(otherCreditAccountDetails.getOwner());
        otherCreditAccount.setAccountIdentifier(otherCreditAccountDetails.getAccountIdentifier());
        otherCreditAccount.setAccountName(otherCreditAccountDetails.getAccountName());
        otherCreditAccount.setCreditLimit(otherCreditAccountDetails.getCreditLimit());
        otherCreditAccount.setBalance(otherCreditAccountDetails.getBalance());
        otherCreditAccount.setPaymentDate(otherCreditAccountDetails.getPaymentDate());
        otherCreditAccount.setMinMonthlyPayment(otherCreditAccountDetails.getMinMonthlyPayment());
        otherCreditAccount.setAutoPay(otherCreditAccountDetails.getAutoPay());
        otherCreditAccount.setFromAccount(otherCreditAccountDetails.getFromAccount());
        otherCreditAccount.setUpdated(otherCreditAccountDetails.getUpdated());
        otherCreditAccount.setApr(otherCreditAccountDetails.getApr());
        otherCreditAccount.setAnnualFee(otherCreditAccountDetails.getAnnualFee());
        otherCreditAccount.setCreatedAt(otherCreditAccountDetails.getCreatedAt());
        otherCreditAccount.setNotes(otherCreditAccountDetails.getNotes());

        return otherCreditAccountRepository.save(otherCreditAccount);
    }
}
