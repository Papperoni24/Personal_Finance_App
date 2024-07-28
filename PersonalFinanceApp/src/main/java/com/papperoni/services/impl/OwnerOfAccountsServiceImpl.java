package com.papperoni.services.impl;

import com.papperoni.models.OwnerOfAccount;
import com.papperoni.repositories.OwnerOfAccountsRepo;
import com.papperoni.services.OwnerOfAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerOfAccountsServiceImpl implements OwnerOfAccountsService {

    private final OwnerOfAccountsRepo repository;

    @Autowired
    public OwnerOfAccountsServiceImpl(OwnerOfAccountsRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<OwnerOfAccount> findAll() {
        return repository.findAll();
    }

    @Override
    public OwnerOfAccount findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public OwnerOfAccount save(OwnerOfAccount owner) {
        return repository.save(owner);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
