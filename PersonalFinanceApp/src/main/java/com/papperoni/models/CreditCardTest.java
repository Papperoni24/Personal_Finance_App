package com.papperoni.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    @Test
    void testDefaultConstructor() {
        CreditCard creditCard = new CreditCard();
        assertNotNull(creditCard);
    }

    @Test
    void testParameterizedConstructor() {
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();

        CreditCard creditCard = new CreditCard(
                1L,
                owner,
                "ID123",
                "Credit Card Account",
                new BigDecimal("5000.00"),
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("200.00"),
                true,
                "Default Payment",
                today,
                new BigDecimal("15.99"),
                new BigDecimal("50.00"),
                now,
                "Some notes"
        );

        assertEquals(1L, creditCard.getCreditCardId());
        assertEquals(owner, creditCard.getOwner());
        assertEquals("ID123", creditCard.getAccountIdentifier());
        assertEquals("Credit Card Account", creditCard.getAccountName());
        assertEquals(new BigDecimal("5000.00"), creditCard.getCreditLimit());
        assertEquals(new BigDecimal("1000.00"), creditCard.getBalance());
        assertEquals(15, creditCard.getPaymentDate());
        assertEquals(new BigDecimal("200.00"), creditCard.getMinMonthlyPayment());
        assertTrue(creditCard.getAutoPay());
        assertEquals("Default Payment", creditCard.getDefaultPayment());
        assertEquals(today, creditCard.getUpdated());
        assertEquals(new BigDecimal("15.99"), creditCard.getApr());
        assertEquals(new BigDecimal("50.00"), creditCard.getAnnualFee());
        assertEquals(now, creditCard.getCreatedAt());
        assertEquals("Some notes", creditCard.getNotes());
    }

    @Test
    void testGettersAndSetters() {
        CreditCard creditCard = new CreditCard();
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();

        creditCard.setCreditCardId(2L);
        creditCard.setOwner(owner);
        creditCard.setAccountIdentifier("ID456");
        creditCard.setAccountName("Savings Account");
        creditCard.setCreditLimit(new BigDecimal("10000.00"));
        creditCard.setBalance(new BigDecimal("2000.00"));
        creditCard.setPaymentDate(25);
        creditCard.setMinMonthlyPayment(new BigDecimal("300.00"));
        creditCard.setAutoPay(false);
        creditCard.setDefaultPayment("No Default");
        creditCard.setUpdated(today);
        creditCard.setApr(new BigDecimal("19.99"));
        creditCard.setAnnualFee(new BigDecimal("75.00"));
        creditCard.setCreatedAt(now);
        creditCard.setNotes("Additional notes");

        assertEquals(2L, creditCard.getCreditCardId());
        assertEquals(owner, creditCard.getOwner());
        assertEquals("ID456", creditCard.getAccountIdentifier());
        assertEquals("Savings Account", creditCard.getAccountName());
        assertEquals(new BigDecimal("10000.00"), creditCard.getCreditLimit());
        assertEquals(new BigDecimal("2000.00"), creditCard.getBalance());
        assertEquals(25, creditCard.getPaymentDate());
        assertEquals(new BigDecimal("300.00"), creditCard.getMinMonthlyPayment());
        assertFalse(creditCard.getAutoPay());
        assertEquals("No Default", creditCard.getDefaultPayment());
        assertEquals(today, creditCard.getUpdated());
        assertEquals(new BigDecimal("19.99"), creditCard.getApr());
        assertEquals(new BigDecimal("75.00"), creditCard.getAnnualFee());
        assertEquals(now, creditCard.getCreatedAt());
        assertEquals("Additional notes", creditCard.getNotes());
    }

    @Test
    void testToString() {
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();

        CreditCard creditCard = new CreditCard(
                1L,
                owner,
                "ID123",
                "Credit Card Account",
                new BigDecimal("5000.00"),
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("200.00"),
                true,
                "Default Payment",
                today,
                new BigDecimal("15.99"),
                new BigDecimal("50.00"),
                now,
                "Some notes"
        );

        String expected = "CreditCard{" +
                "creditCardId=1" +
                ", owner=" + owner +
                ", accountIdentifier='ID123'" +
                ", accountName='Credit Card Account'" +
                ", creditLimit=" + new BigDecimal("5000.00") +
                ", balance=" + new BigDecimal("1000.00") +
                ", paymentDate=15" +
                ", minMonthlyPayment=" + new BigDecimal("200.00") +
                ", autoPay=true" +
                ", defaultPayment='Default Payment'" +
                ", updated=" + today +
                ", apr=" + new BigDecimal("15.99") +
                ", annualFee=" + new BigDecimal("50.00") +
                ", createdAt=" + now +
                ", notes='Some notes'" +
                '}';

        assertEquals(expected, creditCard.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        OwnerOfAccount owner1 = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        OwnerOfAccount owner2 = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();

        CreditCard creditCard1 = new CreditCard(
                1L,
                owner1,
                "ID123",
                "Credit Card Account",
                new BigDecimal("5000.00"),
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("200.00"),
                true,
                "Default Payment",
                today,
                new BigDecimal("15.99"),
                new BigDecimal("50.00"),
                now,
                "Some notes"
        );

        CreditCard creditCard2 = new CreditCard(
                1L,
                owner1,
                "ID123",
                "Credit Card Account",
                new BigDecimal("5000.00"),
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("200.00"),
                true,
                "Default Payment",
                today,
                new BigDecimal("15.99"),
                new BigDecimal("50.00"),
                now,
                "Some notes"
        );

        CreditCard creditCard3 = new CreditCard(
                2L,
                owner2,
                "ID456",
                "Savings Account",
                new BigDecimal("10000.00"),
                new BigDecimal("2000.00"),
                25,
                new BigDecimal("300.00"),
                false,
                "No Default",
                today,
                new BigDecimal("19.99"),
                new BigDecimal("75.00"),
                now,
                "Additional notes"
        );

        assertEquals(creditCard1, creditCard2);
        assertNotEquals(creditCard1, creditCard3);
        assertNotEquals(creditCard2, creditCard3);
        assertNotEquals(creditCard1, null);
        assertNotEquals(creditCard1, new Object());

        assertEquals(creditCard1.hashCode(), creditCard2.hashCode());
        assertNotEquals(creditCard1.hashCode(), creditCard3.hashCode());
    }
}
