package com.papperoni.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CarLoanTest {

    @Test
    void testDefaultConstructor() {
        CarLoan carLoan = new CarLoan();
        assertNotNull(carLoan);
    }

    @Test
    void testParameterizedConstructor() {
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        CarLoan carLoan = new CarLoan(
                1L,
                owner,
                "ID123",
                "Car Loan Account",
                new BigDecimal("5000.00"),
                15,
                new BigDecimal("200.00"),
                true,
                "Default Payment Method",
                LocalDate.of(2024, 8, 1),
                new BigDecimal("3.50"),
                LocalDateTime.of(2024, 7, 31, 10, 0),
                "Some notes"
        );

        assertEquals(1L, carLoan.getCarLoanId());
        assertEquals(owner, carLoan.getOwner());
        assertEquals("ID123", carLoan.getAccountIdentifier());
        assertEquals("Car Loan Account", carLoan.getAccountName());
        assertEquals(new BigDecimal("5000.00"), carLoan.getBalance());
        assertEquals(15, carLoan.getPaymentDate());
        assertEquals(new BigDecimal("200.00"), carLoan.getMinMonthlyPayment());
        assertTrue(carLoan.getAutoPay());
        assertEquals("Default Payment Method", carLoan.getDefaultPayment());
        assertEquals(LocalDate.of(2024, 8, 1), carLoan.getUpdated());
        assertEquals(new BigDecimal("3.50"), carLoan.getApr());
        assertEquals("Some notes", carLoan.getNotes());

        // Assuming 'createdAt' is set to the current time or a specific known time
        assertNotNull(carLoan.getCreatedAt());
    }

    @Test
    void testGettersAndSetters() {
        CarLoan carLoan = new CarLoan();
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock

        carLoan.setCarLoanId(2L);
        carLoan.setOwner(owner);
        carLoan.setAccountIdentifier("ID456");
        carLoan.setAccountName("Auto Loan Account");
        carLoan.setBalance(new BigDecimal("10000.00"));
        carLoan.setPaymentDate(20);
        carLoan.setMinMonthlyPayment(new BigDecimal("300.00"));
        carLoan.setAutoPay(false);
        carLoan.setDefaultPayment("Credit Card");
        carLoan.setUpdated(LocalDate.of(2024, 9, 1));
        carLoan.setApr(new BigDecimal("4.25"));
        carLoan.setCreatedAt(LocalDateTime.of(2024, 8, 31, 9, 0));
        carLoan.setNotes("Additional notes");

        assertEquals(2L, carLoan.getCarLoanId());
        assertEquals(owner, carLoan.getOwner());
        assertEquals("ID456", carLoan.getAccountIdentifier());
        assertEquals("Auto Loan Account", carLoan.getAccountName());
        assertEquals(new BigDecimal("10000.00"), carLoan.getBalance());
        assertEquals(20, carLoan.getPaymentDate());
        assertEquals(new BigDecimal("300.00"), carLoan.getMinMonthlyPayment());
        assertFalse(carLoan.getAutoPay());
        assertEquals("Credit Card", carLoan.getDefaultPayment());
        assertEquals(LocalDate.of(2024, 9, 1), carLoan.getUpdated());
        assertEquals(new BigDecimal("4.25"), carLoan.getApr());
        assertEquals(LocalDateTime.of(2024, 8, 31, 9, 0), carLoan.getCreatedAt());
        assertEquals("Additional notes", carLoan.getNotes());
    }

    @Test
    void testToString() {
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        CarLoan carLoan = new CarLoan(
                1L,
                owner,
                "ID123",
                "Car Loan Account",
                new BigDecimal("5000.00"),
                15,
                new BigDecimal("200.00"),
                true,
                "Default Payment Method",
                LocalDate.of(2024, 8, 1),
                new BigDecimal("3.50"),
                LocalDateTime.of(2024, 7, 31, 10, 0),
                "Some notes"
        );

        String expected = "CarLoan{" +
                "carLoanId=1" +
                ", owner=" + owner +
                ", accountIdentifier='ID123'" +
                ", accountName='Car Loan Account'" +
                ", balance=5000.00" +
                ", paymentDate=15" +
                ", minMonthlyPayment=200.00" +
                ", autoPay=true" +
                ", defaultPayment='Default Payment Method'" +
                ", updated=2024-08-01" +
                ", apr=3.50" +
                ", createdAt=2024-07-31T10:00" +
                ", notes='Some notes'" +
                '}';

        assertEquals(expected, carLoan.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        OwnerOfAccount owner1 = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        OwnerOfAccount owner2 = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock

        CarLoan carLoan1 = new CarLoan(
                1L,
                owner1,
                "ID123",
                "Car Loan Account",
                new BigDecimal("5000.00"),
                15,
                new BigDecimal("200.00"),
                true,
                "Default Payment Method",
                LocalDate.of(2024, 8, 1),
                new BigDecimal("3.50"),
                LocalDateTime.of(2024, 7, 31, 10, 0),
                "Some notes"
        );

        CarLoan carLoan2 = new CarLoan(
                1L,
                owner1,
                "ID123",
                "Car Loan Account",
                new BigDecimal("5000.00"),
                15,
                new BigDecimal("200.00"),
                true,
                "Default Payment Method",
                LocalDate.of(2024, 8, 1),
                new BigDecimal("3.50"),
                LocalDateTime.of(2024, 7, 31, 10, 0),
                "Some notes"
        );

        CarLoan carLoan3 = new CarLoan(
                2L,
                owner2,
                "ID456",
                "Auto Loan Account",
                new BigDecimal("10000.00"),
                20,
                new BigDecimal("300.00"),
                false,
                "Credit Card",
                LocalDate.of(2024, 9, 1),
                new BigDecimal("4.25"),
                LocalDateTime.of(2024, 8, 31, 9, 0),
                "Additional notes"
        );

        assertEquals(carLoan1, carLoan2);
        assertNotEquals(carLoan1, carLoan3);
        assertNotEquals(carLoan2, carLoan3);
        assertNotEquals(carLoan1, null);
        assertNotEquals(carLoan1, new Object());

        assertEquals(carLoan1.hashCode(), carLoan2.hashCode());
        assertNotEquals(carLoan1.hashCode(), carLoan3.hashCode());
    }
}
