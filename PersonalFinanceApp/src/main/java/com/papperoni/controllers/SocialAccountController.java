package com.papperoni.controllers;

import com.papperoni.models.SocialAccount;
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
    public List<SocialAccount> getAllSocialAccounts() {
        return socialAccountService.getAllSocialAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocialAccount> getSocialAccountById(@PathVariable Long id) {
        SocialAccount socialAccount = socialAccountService.getSocialAccountById(id)
                .orElseThrow(() -> new RuntimeException("SocialAccount not found"));
        return ResponseEntity.ok(socialAccount);
    }

    @PostMapping
    public SocialAccount createSocialAccount(@RequestBody SocialAccount socialAccount) {
        return socialAccountService.saveSocialAccount(socialAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocialAccount> updateSocialAccount(@PathVariable Long id, @RequestBody SocialAccount socialAccountDetails) {
        SocialAccount updatedSocialAccount = socialAccountService.updateSocialAccount(id, socialAccountDetails);
        return ResponseEntity.ok(updatedSocialAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocialAccount(@PathVariable Long id) {
        socialAccountService.deleteSocialAccount(id);
        return ResponseEntity.noContent().build();
    }
}

