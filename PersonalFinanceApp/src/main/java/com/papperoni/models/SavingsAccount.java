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
@Table(name = "SavingsAccounts")
public class SavingsAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SavingsID")
    private Long savingsId;

    @ManyToOne
    @JoinColumn(name = "OwnerID", nullable = false)
    @NotNull(message = "Owner is mandatory")
    private int ownerID;

    @Size(max = 100, message = "Account identifier cannot exceed 100 characters")
    @Column(name = "AccountIdentifier", length = 100)
    private String accountIdentifier;

    @Size(max = 100, message = "Account name cannot exceed 100 characters")
    @Column(name = "AccountName", length = 100)
    private String accountName;

    @NotNull(message = "Balance must be specified")
    @PositiveOrZero(message = "Balance must be zero or positive")
    @Column(name = "Balance", precision = 15, scale = 2, nullable = false)
    private BigDecimal balance;

    @NotNull(message = "Creation date is mandatory")
    @Column(name = "CreatedAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Size(max = 255, message = "Notes cannot exceed 255 characters")
    @Column(name = "Notes", length = 255)
    private String notes;

    public SavingsAccount() {
    }

    public SavingsAccount(Long savingsId, String accountIdentifier, String accountName, BigDecimal balance, int ownerID, LocalDateTime createdAt, String notes) {
        this.savingsId = savingsId;
        this.accountIdentifier = accountIdentifier;
        this.accountName = accountName;
        this.balance = balance;
        this.ownerID = ownerID;
        this.createdAt = createdAt;
        this.notes = notes;
    }

    public Long getSavingsId() {
        return savingsId;
    }

    public void setSavingsId(Long savingsId) {
        this.savingsId = savingsId;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwner(int ownerID) {
        this.ownerID = ownerID;
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
        SavingsAccount that = (SavingsAccount) o;
        return Objects.equals(savingsId, that.savingsId) &&
                Objects.equals(ownerID, that.ownerID) &&
                Objects.equals(accountIdentifier, that.accountIdentifier) &&
                Objects.equals(accountName, that.accountName) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(savingsId, ownerID, accountIdentifier, accountName, balance, createdAt, notes);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "savingsId=" + savingsId +
                ", ownerID=" + ownerID +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
