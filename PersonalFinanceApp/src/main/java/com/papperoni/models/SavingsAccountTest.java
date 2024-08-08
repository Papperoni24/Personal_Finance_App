package com.papperoni.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @Test
    void testConstructorAndGetters() {
        LocalDateTime now = LocalDateTime.now();
        SavingsAccount account = new SavingsAccount(1L, "ID123", "My Savings Account", new BigDecimal("1000.00"), 123, now, "Notes");

        assertNotNull(account);
        assertEquals(1L, account.getSavingsId());
        assertEquals("ID123", account.getAccountIdentifier());
        assertEquals("My Savings Account", account.getAccountName());
        assertEquals(new BigDecimal("1000.00"), account.getBalance());
        assertEquals(123, account.getOwnerID());
        assertEquals(now, account.getCreatedAt());
        assertEquals("Notes", account.getNotes());
    }

    @Test
    void testSetters() {
        SavingsAccount account = new SavingsAccount();
        LocalDateTime now = LocalDateTime.now();

        account.setSavingsId(1L);
        account.setAccountIdentifier("ID123");
        account.setAccountName("My Savings Account");
        account.setBalance(new BigDecimal("1000.00"));
        account.setOwner(123);
        account.setCreatedAt(now);
        account.setNotes("Notes");

        assertEquals(1L, account.getSavingsId());
        assertEquals("ID123", account.getAccountIdentifier());
        assertEquals("My Savings Account", account.getAccountName());
        assertEquals(new BigDecimal("1000.00"), account.getBalance());
        assertEquals(123, account.getOwnerID());
        assertEquals(now, account.getCreatedAt());
        assertEquals("Notes", account.getNotes());
    }

    @Test
    void testEqualsAndHashCode() {
        LocalDateTime now = LocalDateTime.now();
        SavingsAccount account1 = new SavingsAccount(1L, "ID123", "My Savings Account", new BigDecimal("1000.00"), 123, now, "Notes");
        SavingsAccount account2 = new SavingsAccount(1L, "ID123", "My Savings Account", new BigDecimal("1000.00"), 123, now, "Notes");
        SavingsAccount account3 = new SavingsAccount(2L, "ID456", "Another Account", new BigDecimal("2000.00"), 456, now.plusDays(1), "Other Notes");

        assertEquals(account1, account2);
        assertNotEquals(account1, account3);

        assertEquals(account1.hashCode(), account2.hashCode());
        assertNotEquals(account1.hashCode(), account3.hashCode());
    }

    @Test
    void testToString() {
        LocalDateTime now = LocalDateTime.now();
        SavingsAccount account = new SavingsAccount(1L, "ID123", "My Savings Account", new BigDecimal("1000.00"), 123, now, "Notes");

        String expectedString = "SavingsAccount{" +
                "savingsId=1" +
                ", ownerID=123" +
                ", accountIdentifier='ID123'" +
                ", accountName='My Savings Account'" +
                ", balance=1000.00" +
                ", createdAt=" + now +
                ", notes='Notes'" +
                '}';

        assertEquals(expectedString, account.toString());
    }
}
