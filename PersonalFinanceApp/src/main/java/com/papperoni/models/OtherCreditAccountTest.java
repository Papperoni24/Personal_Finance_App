package com.papperoni.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OtherCreditAccountTest {

    @Test
    public void testDefaultConstructor() {
        OtherCreditAccount account = new OtherCreditAccount();
        assertNotNull(account);
    }

    @Test
    public void testParameterizedConstructor() {
        LocalDateTime createdAt = LocalDateTime.now();
        OtherCreditAccount account = new OtherCreditAccount(
                1L, 123, "ACC123", "Test Account", BigDecimal.valueOf(5000),
                BigDecimal.valueOf(2500), 15, BigDecimal.valueOf(100),
                1, true, LocalDate.now(), BigDecimal.valueOf(3.5),
                BigDecimal.valueOf(100), createdAt, "Notes");

        assertEquals(1L, account.getOtherCreditAccountId());
        assertEquals(123, account.getOwnerID());
        assertEquals("ACC123", account.getAccountIdentifier());
        assertEquals("Test Account", account.getAccountName());
        assertEquals(BigDecimal.valueOf(5000), account.getCreditLimit());
        assertEquals(BigDecimal.valueOf(2500), account.getBalance());
        assertEquals(15, account.getPaymentDate());
        assertEquals(BigDecimal.valueOf(100), account.getMinMonthlyPayment());
        assertTrue(account.getAutoPay());
        assertEquals(1, account.getDefaultPaymentID());
        assertEquals(LocalDate.now(), account.getUpdated());
        assertEquals(BigDecimal.valueOf(3.5), account.getApr());
        assertEquals(BigDecimal.valueOf(100), account.getAnnualFee());
        assertEquals(createdAt, account.getCreatedAt());
        assertEquals("Notes", account.getNotes());
    }

    @Test
    public void testGettersAndSetters() {
        OtherCreditAccount account = new OtherCreditAccount();
        LocalDateTime createdAt = LocalDateTime.now();

        account.setOtherCreditAccountId(1L);
        account.setOwnerID(123);
        account.setAccountIdentifier("ACC123");
        account.setAccountName("Test Account");
        account.setCreditLimit(BigDecimal.valueOf(5000));
        account.setBalance(BigDecimal.valueOf(2500));
        account.setPaymentDate(15);
        account.setMinMonthlyPayment(BigDecimal.valueOf(100));
        account.setAutoPay(true);
        account.setDefaultPaymentID(1);
        account.setUpdated(LocalDate.now());
        account.setApr(BigDecimal.valueOf(3.5));
        account.setAnnualFee(BigDecimal.valueOf(100));
        account.setCreatedAt(createdAt);
        account.setNotes("Notes");

        assertEquals(1L, account.getOtherCreditAccountId());
        assertEquals(123, account.getOwnerID());
        assertEquals("ACC123", account.getAccountIdentifier());
        assertEquals("Test Account", account.getAccountName());
        assertEquals(BigDecimal.valueOf(5000), account.getCreditLimit());
        assertEquals(BigDecimal.valueOf(2500), account.getBalance());
        assertEquals(15, account.getPaymentDate());
        assertEquals(BigDecimal.valueOf(100), account.getMinMonthlyPayment());
        assertTrue(account.getAutoPay());
        assertEquals(1, account.getDefaultPaymentID());
        assertEquals(LocalDate.now(), account.getUpdated());
        assertEquals(BigDecimal.valueOf(3.5), account.getApr());
        assertEquals(BigDecimal.valueOf(100), account.getAnnualFee());
        assertEquals(createdAt, account.getCreatedAt());
        assertEquals("Notes", account.getNotes());
    }

    @Test
    public void testEqualsAndHashCode() {
        LocalDateTime createdAt = LocalDateTime.now();
        OtherCreditAccount account1 = new OtherCreditAccount(
                1L, 123, "ACC123", "Test Account", BigDecimal.valueOf(5000),
                BigDecimal.valueOf(2500), 15, BigDecimal.valueOf(100),
                1, true, LocalDate.now(), BigDecimal.valueOf(3.5),
                BigDecimal.valueOf(100), createdAt, "Notes");

        OtherCreditAccount account2 = new OtherCreditAccount(
                1L, 123, "ACC123", "Test Account", BigDecimal.valueOf(5000),
                BigDecimal.valueOf(2500), 15, BigDecimal.valueOf(100),
                1, true, LocalDate.now(), BigDecimal.valueOf(3.5),
                BigDecimal.valueOf(100), createdAt, "Notes");

        assertEquals(account1, account2);
        assertEquals(account1.hashCode(), account2.hashCode());
    }

    @Test
    public void testNotEquals() {
        OtherCreditAccount account1 = new OtherCreditAccount(
                1L, 123, "ACC123", "Test Account", BigDecimal.valueOf(5000),
                BigDecimal.valueOf(2500), 15, BigDecimal.valueOf(100),
                1, true, LocalDate.now(), BigDecimal.valueOf(3.5),
                BigDecimal.valueOf(100), LocalDateTime.now(), "Notes");

        OtherCreditAccount account2 = new OtherCreditAccount(
                2L, 124, "ACC124", "Different Account", BigDecimal.valueOf(4000),
                BigDecimal.valueOf(2000), 10, BigDecimal.valueOf(50),
                2, false, LocalDate.now().minusDays(1), BigDecimal.valueOf(5.0),
                BigDecimal.valueOf(200), LocalDateTime.now(), "Different Notes");

        assertNotEquals(account1, account2);
    }

    @Test
    public void testToString() {
        LocalDateTime createdAt = LocalDateTime.now();
        OtherCreditAccount account = new OtherCreditAccount(
                1L, 123, "ACC123", "Test Account", BigDecimal.valueOf(5000),
                BigDecimal.valueOf(2500), 15, BigDecimal.valueOf(100),
                1, true, LocalDate.now(), BigDecimal.valueOf(3.5),
                BigDecimal.valueOf(100), createdAt, "Notes");

        String expectedToString = "OtherCreditAccount{" +
                "otherCreditAccountId=1, " +
                "owner=123, " +
                "accountIdentifier='ACC123', " +
                "accountName='Test Account', " +
                "creditLimit=5000, " +
                "balance=2500, " +
                "paymentDate=15, " +
                "minMonthlyPayment=100, " +
                "autoPay=true, " +
                "defaultPaymentID=1, " +
                "updated=" + LocalDate.now() + ", " +
                "apr=3.5, " +
                "annualFee=100, " +
                "createdAt=" + createdAt + ", " +
                "notes='Notes'}";

        assertEquals(expectedToString, account.toString());
    }
}
