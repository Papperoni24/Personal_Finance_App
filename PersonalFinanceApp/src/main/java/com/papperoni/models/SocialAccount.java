package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SocialAccounts")
public class SocialAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long socialId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    @NotNull
    private OwnerOfAccount owner;

    @NotBlank
    @Size(max = 50)
    private String accountIdentifier;

    @NotBlank
    @Size(max = 100)
    private String accountName;

    @NotNull
    @PositiveOrZero
    private BigDecimal balance;

    @NotNull
    private LocalDateTime createdAt;

    @Size(max = 500)
    private String notes;

    public SocialAccount() {
    }

    public SocialAccount(Long socialId, String accountIdentifier, OwnerOfAccount owner, String accountName, BigDecimal balance, LocalDateTime createdAt, String notes) {
        this.socialId = socialId;
        this.accountIdentifier = accountIdentifier;
        this.owner = owner;
        this.accountName = accountName;
        this.balance = balance;
        this.createdAt = createdAt;
        this.notes = notes;
    }

    public Long getSocialId() {
        return socialId;
    }

    public void setSocialId(Long socialId) {
        this.socialId = socialId;
    }

    public OwnerOfAccount getOwner() {
        return owner;
    }

    public void setOwner(OwnerOfAccount owner) {
        this.owner = owner;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

