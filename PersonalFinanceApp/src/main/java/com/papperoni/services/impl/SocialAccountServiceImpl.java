package com.papperoni.services.impl;

import com.papperoni.models.OtherDepositAccount;
import com.papperoni.repositories.SocialAccountRepo;
import com.papperoni.services.SocialAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialAccountServiceImpl implements SocialAccountService {

    private final SocialAccountRepo socialAccountRepository;

    @Autowired
    public SocialAccountServiceImpl(SocialAccountRepo socialAccountRepository) {
        this.socialAccountRepository = socialAccountRepository;
    }

    @Override
    public List<OtherDepositAccount> getAllSocialAccounts() {
        return socialAccountRepository.findAll();
    }

    @Override
    public Optional<OtherDepositAccount> getSocialAccountById(Long id) {
        return socialAccountRepository.findById(id);
    }

    @Override
    public OtherDepositAccount saveSocialAccount(OtherDepositAccount otherDepositAccount) {
        return socialAccountRepository.save(otherDepositAccount);
    }

    @Override
    public void deleteSocialAccount(Long id) {
        socialAccountRepository.deleteById(id);
    }

    @Override
    public OtherDepositAccount updateSocialAccount(Long id, OtherDepositAccount otherDepositAccountDetails) {
        OtherDepositAccount otherDepositAccount = socialAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OtherDepositAccount not found"));

        otherDepositAccount.setAccountName(otherDepositAccountDetails.getAccountName());
        otherDepositAccount.setAccountIdentifier(otherDepositAccountDetails.getAccountIdentifier());
        otherDepositAccount.setBalance(otherDepositAccountDetails.getBalance());
        otherDepositAccount.setNotes(otherDepositAccountDetails.getNotes());

        return socialAccountRepository.save(otherDepositAccount);
    }
}
