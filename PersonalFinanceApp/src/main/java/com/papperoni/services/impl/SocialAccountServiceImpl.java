package com.papperoni.services.impl;

import com.papperoni.models.SocialAccount;
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
    public List<SocialAccount> getAllSocialAccounts() {
        return socialAccountRepository.findAll();
    }

    @Override
    public Optional<SocialAccount> getSocialAccountById(Long id) {
        return socialAccountRepository.findById(id);
    }

    @Override
    public SocialAccount saveSocialAccount(SocialAccount socialAccount) {
        return socialAccountRepository.save(socialAccount);
    }

    @Override
    public void deleteSocialAccount(Long id) {
        socialAccountRepository.deleteById(id);
    }

    @Override
    public SocialAccount updateSocialAccount(Long id, SocialAccount socialAccountDetails) {
        SocialAccount socialAccount = socialAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SocialAccount not found"));

        socialAccount.setAccountName(socialAccountDetails.getAccountName());
        socialAccount.setAccountIdentifier(socialAccountDetails.getAccountIdentifier());
        socialAccount.setBalance(socialAccountDetails.getBalance());
        socialAccount.setNotes(socialAccountDetails.getNotes());

        return socialAccountRepository.save(socialAccount);
    }
}
