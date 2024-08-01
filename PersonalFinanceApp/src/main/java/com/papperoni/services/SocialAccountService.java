package com.papperoni.services;

import com.papperoni.models.OtherDepositAccount;

import java.util.List;
import java.util.Optional;

public interface SocialAccountService {

    List<OtherDepositAccount> getAllSocialAccounts();

    Optional<OtherDepositAccount> getSocialAccountById(Long id);

    OtherDepositAccount saveSocialAccount(OtherDepositAccount otherDepositAccount);

    void deleteSocialAccount(Long id);

    OtherDepositAccount updateSocialAccount(Long id, OtherDepositAccount otherDepositAccountDetails);
}

