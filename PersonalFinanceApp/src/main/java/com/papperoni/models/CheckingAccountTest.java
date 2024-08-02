package com.papperoni.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CheckingAccountTest {

    @Test
    void testDefaultConstructor() {
        CheckingAccount checkingAccount = new CheckingAccount();
        assertNotNull(checkingAccount);
    }

    @Test
    void testParameterizedConstructor() {
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        CheckingAccount checkingAccount = new CheckingAccount(
                1L,
                owner,
                "ID123",
                "Checking Account",
                new BigDecimal("1000.00"),
                LocalDateTime.of(2024, 7, 31, 10, 0),
                "Some notes"
        );

        assertEquals(1L, checkingAccount.getCheckingId());
        assertEquals(owner, checkingAccount.getOwner());
        assertEquals("ID123", checkingAccount.getAccountIdentifier());
        assertEquals("Checking Account", checkingAccount.getAccountName());
        assertEquals(new BigDecimal("1000.00"), checkingAccount.getBalance());
        assertEquals(LocalDateTime.of(2024, 7, 31, 10, 0), checkingAccount.getCreatedAt());
        assertEquals("Some notes", checkingAccount.getNotes());
    }

    @Test
    void testGettersAndSetters() {
        CheckingAccount checkingAccount = new CheckingAccount();
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock

        checkingAccount.setCheckingId(2L);
        checkingAccount.setOwner(owner);
        checkingAccount.setAccountIdentifier("ID456");
        checkingAccount.setAccountName("Savings Account");
        checkingAccount.setBalance(new BigDecimal("2000.00"));
        checkingAccount.setCreatedAt(LocalDateTime.of(2024, 8, 31, 9, 0));
        checkingAccount.setNotes("Additional notes");

        assertEquals(2L, checkingAccount.getCheckingId());
        assertEquals(owner, checkingAccount.getOwner());
        assertEquals("ID456", checkingAccount.getAccountIdentifier());
        assertEquals("Savings Account", checkingAccount.getAccountName());
        assertEquals(new BigDecimal("2000.00"), checkingAccount.getBalance());
        assertEquals(LocalDateTime.of(2024, 8, 31, 9, 0), checkingAccount.getCreatedAt());
        assertEquals("Additional notes", checkingAccount.getNotes());
    }

    @Test
    void testToString() {
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        CheckingAccount checkingAccount = new CheckingAccount(
                1L,
                owner,
                "ID123",
                "Checking Account",
                new BigDecimal("1000.00"),
                LocalDateTime.of(2024, 7, 31, 10, 0),
                "Some notes"
        );

        String expected = "CheckingAccount{" +
                "checkingId=1" +
                ", owner=" + owner +
                ", accountIdentifier='ID123'" +
                ", accountName='Checking Account'" +
                ", balance=" + new BigDecimal("1000.00") +
                ", createdAt=" + LocalDateTime.of(2024, 7, 31, 10, 0) +
                ", notes='Some notes'" +
                '}';

        assertEquals(expected, checkingAccount.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        OwnerOfAccount owner1 = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        OwnerOfAccount owner2 = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock

        CheckingAccount checkingAccount1 = new CheckingAccount(
                1L,
                owner1,
                "ID123",
                "Checking Account",
                new BigDecimal("1000.00"),
                LocalDateTime.of(2024, 7, 31, 10, 0),
                "Some notes"
        );

        CheckingAccount checkingAccount2 = new CheckingAccount(
                1L,
                owner1,
                "ID123",
                "Checking Account",
                new BigDecimal("1000.00"),
                LocalDateTime.of(2024, 7, 31, 10, 0),
                "Some notes"
        );

        CheckingAccount checkingAccount3 = new CheckingAccount(
                2L,
                owner2,
                "ID456",
                "Savings Account",
                new BigDecimal("2000.00"),
                LocalDateTime.of(2024, 8, 31, 9, 0),
                "Additional notes"
        );

        assertEquals(checkingAccount1, checkingAccount2);
        assertNotEquals(checkingAccount1, checkingAccount3);
        assertNotEquals(checkingAccount2, checkingAccount3);
        assertNotEquals(checkingAccount1, null);
        assertNotEquals(checkingAccount1, new Object());

        assertEquals(checkingAccount1.hashCode(), checkingAccount2.hashCode());
        assertNotEquals(checkingAccount1.hashCode(), checkingAccount3.hashCode());
    }
}
