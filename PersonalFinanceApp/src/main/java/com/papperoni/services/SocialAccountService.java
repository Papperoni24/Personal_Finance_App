package com.papperoni.services;

import com.papperoni.models.SocialAccount;

import java.util.List;
import java.util.Optional;

public interface SocialAccountService {

    List<SocialAccount> getAllSocialAccounts();

    Optional<SocialAccount> getSocialAccountById(Long id);

    SocialAccount saveSocialAccount(SocialAccount socialAccount);

    void deleteSocialAccount(Long id);

    SocialAccount updateSocialAccount(Long id, SocialAccount socialAccountDetails);
}

