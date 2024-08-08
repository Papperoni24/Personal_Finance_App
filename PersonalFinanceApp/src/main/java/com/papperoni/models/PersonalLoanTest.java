package com.papperoni.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class PersonalLoanTest {

    private PersonalLoan loan;

    @BeforeEach
    public void setUp() {
        loan = new PersonalLoan(
                1L,
                1001,
                "Account123",
                "Main Account",
                BigDecimal.valueOf(5000.00),
                15,
                BigDecimal.valueOf(150.00),
                true,
                12345,
                LocalDate.now().minusMonths(1),
                BigDecimal.valueOf(5.75),
                LocalDateTime.now(),
                "Sample notes"
        );
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1L, loan.getPersonalLoanId());
        assertEquals(1001, loan.getOwnerID());
        assertEquals("Account123", loan.getAccountIdentifier());
        assertEquals("Main Account", loan.getAccountName());
        assertEquals(BigDecimal.valueOf(5000.00), loan.getBalance());
        assertEquals(15, loan.getPaymentDate());
        assertEquals(BigDecimal.valueOf(150.00), loan.getMinMonthlyPayment());
        assertTrue(loan.getAutoPay());
        assertEquals(12345, loan.getDefaultPaymentID());
        assertEquals(LocalDate.now().minusMonths(1), loan.getUpdated());
        assertEquals(BigDecimal.valueOf(5.75), loan.getApr());
        assertNotNull(loan.getCreatedAt());
        assertEquals("Sample notes", loan.getNotes());
    }

    @Test
    public void testSetters() {
        loan.setPersonalLoanId(2L);
        loan.setOwner(1002);
        loan.setAccountIdentifier("Account456");
        loan.setAccountName("Secondary Account");
        loan.setBalance(BigDecimal.valueOf(6000.00));
        loan.setPaymentDate(20);
        loan.setMinMonthlyPayment(BigDecimal.valueOf(200.00));
        loan.setAutoPay(false);
        loan.setDefaultPaymentID(54321);
        loan.setUpdated(LocalDate.now().minusDays(5));
        loan.setApr(BigDecimal.valueOf(4.50));
        loan.setCreatedAt(LocalDateTime.now().minusDays(10));
        loan.setNotes("Updated notes");

        assertEquals(2L, loan.getPersonalLoanId());
        assertEquals(1002, loan.getOwnerID());
        assertEquals("Account456", loan.getAccountIdentifier());
        assertEquals("Secondary Account", loan.getAccountName());
        assertEquals(BigDecimal.valueOf(6000.00), loan.getBalance());
        assertEquals(20, loan.getPaymentDate());
        assertEquals(BigDecimal.valueOf(200.00), loan.getMinMonthlyPayment());
        assertFalse(loan.getAutoPay());
        assertEquals(54321, loan.getDefaultPaymentID());
        assertEquals(LocalDate.now().minusDays(5), loan.getUpdated());
        assertEquals(BigDecimal.valueOf(4.50), loan.getApr());
        assertNotNull(loan.getCreatedAt());
        assertEquals("Updated notes", loan.getNotes());
    }

    @Test
    public void testEqualsAndHashCode() {
        PersonalLoan anotherLoan = new PersonalLoan(
                1L,
                1001,
                "Account123",
                "Main Account",
                BigDecimal.valueOf(5000.00),
                15,
                BigDecimal.valueOf(150.00),
                true,
                12345,
                LocalDate.now().minusMonths(1),
                BigDecimal.valueOf(5.75),
                LocalDateTime.now(),
                "Sample notes"
        );

        assertEquals(loan, anotherLoan);
        assertEquals(loan.hashCode(), anotherLoan.hashCode());
    }

    @Test
    public void testNotEquals() {
        PersonalLoan differentLoan = new PersonalLoan(
                2L,
                1002,
                "Account456",
                "Secondary Account",
                BigDecimal.valueOf(6000.00),
                20,
                BigDecimal.valueOf(200.00),
                false,
                54321,
                LocalDate.now().minusDays(5),
                BigDecimal.valueOf(4.50),
                LocalDateTime.now().minusDays(10),
                "Updated notes"
        );

        assertNotEquals(loan, differentLoan);
    }

    @Test
    public void testToString() {
        String expectedString = "PersonalLoan{" +
                "personalLoanId=" + loan.getPersonalLoanId() +
                ", ownerID=" + loan.getOwnerID() +
                ", accountIdentifier='" + loan.getAccountIdentifier() + '\'' +
                ", accountName='" + loan.getAccountName() + '\'' +
                ", balance=" + loan.getBalance() +
                ", paymentDate=" + loan.getPaymentDate() +
                ", minMonthlyPayment=" + loan.getMinMonthlyPayment() +
                ", autoPay=" + loan.getAutoPay() +
                ", defaultPaymentID=" + loan.getDefaultPaymentID() +
                ", updated=" + loan.getUpdated() +
                ", apr=" + loan.getApr() +
                ", createdAt=" + loan.getCreatedAt() +
                ", notes='" + loan.getNotes() + '\'' +
                '}';

        assertEquals(expectedString, loan.toString());
    }
}
