package com.papperoni.controllers;

import com.papperoni.models.SavingsAccount;
import com.papperoni.services.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savings-accounts")
public class SavingsAccountController {

    private final SavingsAccountService savingsAccountService;

    @Autowired
    public SavingsAccountController(SavingsAccountService savingsAccountService) {
        this.savingsAccountService = savingsAccountService;
    }

    @GetMapping
    public List<SavingsAccount> getAllSavingsAccounts() {
        return savingsAccountService.getAllSavingsAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsAccount> getSavingsAccountById(@PathVariable Long id) {
        SavingsAccount savingsAccount = savingsAccountService.getSavingsAccountById(id)
                .orElseThrow(() -> new RuntimeException("SavingsAccount not found"));
        return ResponseEntity.ok(savingsAccount);
    }

    @PostMapping
    public SavingsAccount createSavingsAccount(@RequestBody SavingsAccount savingsAccount) {
        return savingsAccountService.saveSavingsAccount(savingsAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavingsAccount> updateSavingsAccount(@PathVariable Long id, @RequestBody SavingsAccount savingsAccountDetails) {
        SavingsAccount updatedSavingsAccount = savingsAccountService.updateSavingsAccount(id, savingsAccountDetails);
        return ResponseEntity.ok(updatedSavingsAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsAccount(@PathVariable Long id) {
        savingsAccountService.deleteSavingsAccount(id);
        return ResponseEntity.noContent().build();
    }
}
