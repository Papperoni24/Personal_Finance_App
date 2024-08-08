package com.papperoni.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OtherDepositAccountTest {

    private OtherDepositAccount account1;
    private OtherDepositAccount account2;

    @BeforeEach
    public void setUp() {
        account1 = new OtherDepositAccount(
                1L,
                "ID12345",
                1001,
                "Main Account",
                new BigDecimal("1500.00"),
                LocalDateTime.now(),
                "Test notes"
        );

        account2 = new OtherDepositAccount(
                1L,
                "ID12345",
                1001,
                "Main Account",
                new BigDecimal("1500.00"),
                LocalDateTime.now(),
                "Test notes"
        );
    }

    @Test
    public void testGettersAndSetters() {
        account1.setOtherDepositID(2L);
        assertEquals(2L, account1.getOtherDepositID());

        account1.setOwnerID(1002);
        assertEquals(1002, account1.getOwnerID());

        account1.setAccountIdentifier("ID54321");
        assertEquals("ID54321", account1.getAccountIdentifier());

        account1.setAccountName("Secondary Account");
        assertEquals("Secondary Account", account1.getAccountName());

        account1.setBalance(new BigDecimal("2000.00"));
        assertEquals(new BigDecimal("2000.00"), account1.getBalance());

        LocalDateTime now = LocalDateTime.now();
        account1.setCreatedAt(now);
        assertEquals(now, account1.getCreatedAt());

        account1.setNotes("Updated notes");
        assertEquals("Updated notes", account1.getNotes());
    }

    @Test
    public void testEqualsAndHashCode() {
        assertEquals(account1, account2);
        assertEquals(account1.hashCode(), account2.hashCode());

        account2.setAccountName("Different Account");
        assertNotEquals(account1, account2);
        assertNotEquals(account1.hashCode(), account2.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "OtherDepositAccount{" +
                "otherDepositID=" + 1L +
                ", ownerID=" + 1001 +
                ", accountIdentifier='ID12345'" +
                ", accountName='Main Account'" +
                ", balance=" + new BigDecimal("1500.00") +
                ", createdAt=" + account1.getCreatedAt() +
                ", notes='Test notes'" +
                '}';
        assertTrue(account1.toString().contains("OtherDepositAccount{"));
        assertTrue(account1.toString().contains("otherDepositID=" + 1L));
        assertTrue(account1.toString().contains("ownerID=" + 1001));
        assertTrue(account1.toString().contains("accountIdentifier='ID12345'"));
        assertTrue(account1.toString().contains("accountName='Main Account'"));
        assertTrue(account1.toString().contains("balance=" + new BigDecimal("1500.00")));
        assertTrue(account1.toString().contains("notes='Test notes'"));
    }
}
