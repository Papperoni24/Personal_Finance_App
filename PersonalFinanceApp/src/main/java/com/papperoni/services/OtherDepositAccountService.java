package com.papperoni.services;

import com.papperoni.models.OtherDepositAccount;

import java.util.List;
import java.util.Optional;

public interface OtherDepositAccountService {

    List<OtherDepositAccount> getAllOtherDepositAccounts();

    Optional<OtherDepositAccount> getOtherDepositAccountById(Long id);

    OtherDepositAccount saveOtherDepositAccount(OtherDepositAccount otherDepositAccount);

    void deleteOtherDepositAccount(Long id);

    OtherDepositAccount updateOtherDepositAccount(Long id, OtherDepositAccount otherDepositAccountDetails);
}


