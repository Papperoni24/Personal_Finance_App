package com.papperoni.controllers;

import com.papperoni.models.OtherDepositAccount;
import com.papperoni.services.SocialAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/social-accounts")
public class SocialAccountController {

    private final SocialAccountService socialAccountService;

    @Autowired
    public SocialAccountController(SocialAccountService socialAccountService) {
        this.socialAccountService = socialAccountService;
    }

    @GetMapping
    public List<OtherDepositAccount> getAllSocialAccounts() {
        return socialAccountService.getAllSocialAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherDepositAccount> getSocialAccountById(@PathVariable Long id) {
        OtherDepositAccount otherDepositAccount = socialAccountService.getSocialAccountById(id)
                .orElseThrow(() -> new RuntimeException("OtherDepositAccount not found"));
        return ResponseEntity.ok(otherDepositAccount);
    }

    @PostMapping
    public OtherDepositAccount createSocialAccount(@RequestBody OtherDepositAccount otherDepositAccount) {
        return socialAccountService.saveSocialAccount(otherDepositAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OtherDepositAccount> updateSocialAccount(@PathVariable Long id, @RequestBody OtherDepositAccount otherDepositAccountDetails) {
        OtherDepositAccount updatedOtherDepositAccount = socialAccountService.updateSocialAccount(id, otherDepositAccountDetails);
        return ResponseEntity.ok(updatedOtherDepositAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocialAccount(@PathVariable Long id) {
        socialAccountService.deleteSocialAccount(id);
        return ResponseEntity.noContent().build();
    }
}

