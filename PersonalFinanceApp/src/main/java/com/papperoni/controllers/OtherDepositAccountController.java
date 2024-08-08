package com.papperoni.controllers;

import com.papperoni.models.OtherDepositAccount;
import com.papperoni.services.OtherDepositAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/other-deposit-accounts")
public class OtherDepositAccountController {

    private final OtherDepositAccountService otherDepositAccountService;

    @Autowired
    public OtherDepositAccountController(OtherDepositAccountService otherDepositAccountService) {
        this.otherDepositAccountService = otherDepositAccountService;
    }

    @GetMapping
    public ResponseEntity<List<OtherDepositAccount>> getAllOtherDepositAccounts() {
        List<OtherDepositAccount> accounts = otherDepositAccountService.getAllOtherDepositAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherDepositAccount> getOtherDepositAccountById(@PathVariable("id") Long id) {
        Optional<OtherDepositAccount> account = otherDepositAccountService.getOtherDepositAccountById(id);
        return account.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<OtherDepositAccount> createOtherDepositAccount(@RequestBody OtherDepositAccount otherDepositAccount) {
        OtherDepositAccount savedAccount = otherDepositAccountService.saveOtherDepositAccount(otherDepositAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OtherDepositAccount> updateOtherDepositAccount(@PathVariable("id") Long id,
                                                                         @RequestBody OtherDepositAccount otherDepositAccountDetails) {
        try {
            OtherDepositAccount updatedAccount = otherDepositAccountService.updateOtherDepositAccount(id, otherDepositAccountDetails);
            return ResponseEntity.ok(updatedAccount);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOtherDepositAccount(@PathVariable("id") Long id) {
        try {
            otherDepositAccountService.deleteOtherDepositAccount(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
