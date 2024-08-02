package com.papperoni.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "AccountTypes")
public class AccountType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountTypeID")
    private int accountTypeID;

    @Column(name = "AccountTypeName", unique = true, nullable = false, length = 50)
    private String accountTypeName;

    @Column(name = "Notes", length = 255)
    private String notes;

    // Default constructor
    public AccountType() {}

    // Parameterized constructor
    public AccountType(String accountTypeName, String notes) {
        this.accountTypeName = accountTypeName;
        this.notes = notes;
    }

    // Getters and Setters
    public int getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(int accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Override toString method
    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeID=" + accountTypeID +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return accountTypeID == that.accountTypeID && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, accountTypeName, notes);
    }
}

