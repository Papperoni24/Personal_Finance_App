package com.papperoni.services;

import com.papperoni.models.OwnerOfAccount;

import java.util.List;

public interface OwnerOfAccountsService {
    List<OwnerOfAccount> findAll();
    OwnerOfAccount findById(Long id);
    OwnerOfAccount save(OwnerOfAccount owner);
    void deleteById(Long id);
}
