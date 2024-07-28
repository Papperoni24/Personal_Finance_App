package com.papperoni.controllers;

import com.papperoni.models.CheckingAccount;
import com.papperoni.services.CheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkingaccounts")
public class CheckingAccountController {

    private final CheckingAccountService service;

    @Autowired
    public CheckingAccountController(CheckingAccountService service) {
        this.service = service;
    }

    @GetMapping
    public List<CheckingAccount> getAllCheckingAccounts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CheckingAccount getCheckingAccountById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public CheckingAccount createCheckingAccount(@RequestBody CheckingAccount checkingAccount) {
        return service.save(checkingAccount);
    }

    @PutMapping("/{id}")
    public CheckingAccount updateCheckingAccount(@PathVariable Long id, @RequestBody CheckingAccount checkingAccount) {
        checkingAccount.setCheckingId(id);
        return service.save(checkingAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteCheckingAccount(@PathVariable Long id) {
        service.deleteById(id);
    }
}
