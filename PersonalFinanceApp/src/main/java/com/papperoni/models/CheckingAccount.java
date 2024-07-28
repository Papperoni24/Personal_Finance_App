package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "CheckingAccounts")
public class CheckingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkingId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    @NotNull(message = "Owner is mandatory")
    private OwnerOfAccount owner;

    @Size(max = 50, message = "Account identifier should not exceed 50 characters")
    private String accountIdentifier;

    @Size(max = 100, message = "Account name should not exceed 100 characters")
    private String accountName;

    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be positive")
    private BigDecimal balance;

    @PastOrPresent(message = "Creation date cannot be in the future")
    private LocalDateTime createdAt;

    @Size(max = 255, message = "Notes should not exceed 255 characters")
    private String notes;

    public CheckingAccount() {
    }

    public CheckingAccount(Long checkingId, OwnerOfAccount owner, String accountIdentifier, String accountName, BigDecimal balance, LocalDateTime createdAt, String notes) {
        this.checkingId = checkingId;
        this.owner = owner;
        this.accountIdentifier = accountIdentifier;
        this.accountName = accountName;
        this.balance = balance;
        this.createdAt = createdAt;
        this.notes = notes;
    }

    public Long getCheckingId() {
        return checkingId;
    }

    public void setCheckingId(Long checkingId) {
        this.checkingId = checkingId;
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
        CheckingAccount that = (CheckingAccount) o;
        return Objects.equals(checkingId, that.checkingId) && Objects.equals(owner, that.owner) && Objects.equals(accountIdentifier, that.accountIdentifier) && Objects.equals(accountName, that.accountName) && Objects.equals(balance, that.balance) && Objects.equals(createdAt, that.createdAt) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkingId, owner, accountIdentifier, accountName, balance, createdAt, notes);
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "checkingId=" + checkingId +
                ", owner=" + owner +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
