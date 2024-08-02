package com.papperoni.controllers;

import com.papperoni.models.AccountType;
import com.papperoni.services.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account-types")
public class AccountTypeController {

    private final AccountTypeService accountTypeService;

    @Autowired
    public AccountTypeController(AccountTypeService accountTypeService) {
        this.accountTypeService = accountTypeService;
    }

    @PostMapping
    public ResponseEntity<AccountType> createAccountType(@RequestBody AccountType accountType) {
        AccountType savedAccountType = accountTypeService.saveAccountType(accountType);
        return new ResponseEntity<>(savedAccountType, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountType> getAccountTypeById(@PathVariable int id) {
        Optional<AccountType> accountType = accountTypeService.getAccountTypeById(id);
        return accountType.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AccountType>> getAllAccountTypes() {
        List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();
        return ResponseEntity.ok(accountTypes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountType(@PathVariable int id) {
        accountTypeService.deleteAccountType(id);
        return ResponseEntity.noContent().build();
    }
}

