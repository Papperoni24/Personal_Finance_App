package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "OtherDepositAccounts")
public class OtherDepositAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OtherDepositID")
    private Long otherDepositID;

    @ManyToOne
    @JoinColumn(name = "OwnerID", nullable = false)
    private int ownerID;

    @Size(max = 100)
    @Column(name = "AccountIdentifier", length = 100)
    private String accountIdentifier;

    @Size(max = 100)
    @Column(name = "AccountName", length = 100)
    private String accountName;

    @Column(name = "Balance", precision = 15, scale = 2)
    private BigDecimal balance;

    @Column(name = "CreatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Size(max = 255)
    @Column(name = "Notes", length = 255)
    private String notes;

    public OtherDepositAccount() {
    }

    public OtherDepositAccount(Long otherDepositID, String accountIdentifier, int ownerID, String accountName, BigDecimal balance, LocalDateTime createdAt, String notes) {
        this.otherDepositID = otherDepositID;
        this.accountIdentifier = accountIdentifier;
        this.ownerID = ownerID;
        this.accountName = accountName;
        this.balance = balance;
        this.createdAt = createdAt;
        this.notes = notes;
    }

    public Long getOtherDepositID() {
        return otherDepositID;
    }

    public void setOtherDepositID(Long otherDepositID) {
        this.otherDepositID = otherDepositID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
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
        OtherDepositAccount that = (OtherDepositAccount) o;
        return Objects.equals(otherDepositID, that.otherDepositID) && Objects.equals(ownerID, that.ownerID) && Objects.equals(accountIdentifier, that.accountIdentifier) && Objects.equals(accountName, that.accountName) && Objects.equals(balance, that.balance) && Objects.equals(createdAt, that.createdAt) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(otherDepositID, ownerID, accountIdentifier, accountName, balance, createdAt, notes);
    }

    @Override
    public String toString() {
        return "OtherDepositAccount{" +
                "otherDepositID=" + otherDepositID +
                ", ownerID=" + ownerID +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
