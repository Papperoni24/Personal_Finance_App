package com.papperoni.services;

import com.papperoni.models.AccountType;
import java.util.List;
import java.util.Optional;

public interface AccountTypeService {
    AccountType saveAccountType(AccountType accountType);
    Optional<AccountType> getAccountTypeById(int id);
    List<AccountType> getAllAccountTypes();
    void deleteAccountType(int id);
}
