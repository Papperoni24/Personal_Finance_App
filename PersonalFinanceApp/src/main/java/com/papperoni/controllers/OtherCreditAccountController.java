package com.papperoni.controllers;

import com.papperoni.models.OtherCreditAccount;
import com.papperoni.services.OtherCreditAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/other-credit-accounts")
public class OtherCreditAccountController {

    private final OtherCreditAccountService otherCreditAccountService;

    @Autowired
    public OtherCreditAccountController(OtherCreditAccountService otherCreditAccountService) {
        this.otherCreditAccountService = otherCreditAccountService;
    }

    @GetMapping
    public List<OtherCreditAccount> getAllOtherCreditAccounts() {
        return otherCreditAccountService.getAllOtherCreditAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherCreditAccount> getOtherCreditAccountById(@PathVariable Long id) {
        OtherCreditAccount otherCreditAccount = otherCreditAccountService.getOtherCreditAccountById(id)
                .orElseThrow(() -> new RuntimeException("OtherCreditAccount not found"));
        return ResponseEntity.ok(otherCreditAccount);
    }

    @PostMapping
    public OtherCreditAccount createOtherCreditAccount(@RequestBody OtherCreditAccount otherCreditAccount) {
        return otherCreditAccountService.saveOtherCreditAccount(otherCreditAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OtherCreditAccount> updateOtherCreditAccount(@PathVariable Long id, @RequestBody OtherCreditAccount otherCreditAccountDetails) {
        OtherCreditAccount updatedOtherCreditAccount = otherCreditAccountService.updateOtherCreditAccount(id, otherCreditAccountDetails);
        return ResponseEntity.ok(updatedOtherCreditAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOtherCreditAccount(@PathVariable Long id) {
        otherCreditAccountService.deleteOtherCreditAccount(id);
        return ResponseEntity.noContent().build();
    }
}

