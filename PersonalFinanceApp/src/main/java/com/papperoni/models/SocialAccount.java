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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialAccount that = (SocialAccount) o;
        return Objects.equals(socialId, that.socialId) && Objects.equals(owner, that.owner) && Objects.equals(accountIdentifier, that.accountIdentifier) && Objects.equals(accountName, that.accountName) && Objects.equals(balance, that.balance) && Objects.equals(createdAt, that.createdAt) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socialId, owner, accountIdentifier, accountName, balance, createdAt, notes);
    }

    @Override
    public String toString() {
        return "SocialAccount{" +
                "socialId=" + socialId +
                ", owner=" + owner +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
