package com.papperoni.services;

import com.papperoni.models.OtherCreditAccount;

import java.util.List;
import java.util.Optional;

public interface OtherCreditAccountService {

    List<OtherCreditAccount> getAllOtherCreditAccounts();

    Optional<OtherCreditAccount> getOtherCreditAccountById(Long id);

    OtherCreditAccount saveOtherCreditAccount(OtherCreditAccount otherCreditAccount);

    void deleteOtherCreditAccount(Long id);

    OtherCreditAccount updateOtherCreditAccount(Long id, OtherCreditAccount otherCreditAccountDetails);
}

