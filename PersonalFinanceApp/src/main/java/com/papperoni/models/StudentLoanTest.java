package com.papperoni.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class StudentLoanTest {

    @Test
    public void testConstructorAndGetters() {
        LocalDateTime createdAt = LocalDateTime.now();
        StudentLoan studentLoan = new StudentLoan(
                1L,
                123,
                "ID12345",
                new BigDecimal("5000.00"),
                "Student Loan",
                15,
                new BigDecimal("100.00"),
                true,
                1,
                LocalDate.now(),
                new BigDecimal("5.50"),
                createdAt,
                "Notes here"
        );

        assertEquals(1L, studentLoan.getStudentLoanId());
        assertEquals(123, studentLoan.getOwnerID());
        assertEquals("ID12345", studentLoan.getAccountIdentifier());
        assertEquals("Student Loan", studentLoan.getAccountName());
        assertEquals(new BigDecimal("5000.00"), studentLoan.getBalance());
        assertEquals(15, studentLoan.getPaymentDate());
        assertEquals(new BigDecimal("100.00"), studentLoan.getMinMonthlyPayment());
        assertTrue(studentLoan.getAutoPay());
        assertEquals(1, studentLoan.getDefaultPaymentID());
        assertEquals(LocalDate.now(), studentLoan.getUpdated());
        assertEquals(new BigDecimal("5.50"), studentLoan.getApr());
        assertEquals(createdAt, studentLoan.getCreatedAt());
        assertEquals("Notes here", studentLoan.getNotes());
    }

    @Test
    public void testSetters() {
        StudentLoan studentLoan = new StudentLoan();

        studentLoan.setStudentLoanId(1L);
        studentLoan.setOwnerID(123);
        studentLoan.setAccountIdentifier("ID12345");
        studentLoan.setAccountName("Student Loan");
        studentLoan.setBalance(new BigDecimal("5000.00"));
        studentLoan.setPaymentDate(15);
        studentLoan.setMinMonthlyPayment(new BigDecimal("100.00"));
        studentLoan.setAutoPay(true);
        studentLoan.setDefaultPaymentID(1);
        studentLoan.setUpdated(LocalDate.now());
        studentLoan.setApr(new BigDecimal("5.50"));
        studentLoan.setCreatedAt(LocalDateTime.now());
        studentLoan.setNotes("Notes here");

        assertEquals(1L, studentLoan.getStudentLoanId());
        assertEquals(123, studentLoan.getOwnerID());
        assertEquals("ID12345", studentLoan.getAccountIdentifier());
        assertEquals("Student Loan", studentLoan.getAccountName());
        assertEquals(new BigDecimal("5000.00"), studentLoan.getBalance());
        assertEquals(15, studentLoan.getPaymentDate());
        assertEquals(new BigDecimal("100.00"), studentLoan.getMinMonthlyPayment());
        assertTrue(studentLoan.getAutoPay());
        assertEquals(1, studentLoan.getDefaultPaymentID());
        assertEquals(LocalDate.now(), studentLoan.getUpdated());
        assertEquals(new BigDecimal("5.50"), studentLoan.getApr());
        assertNotNull(studentLoan.getCreatedAt());
        assertEquals("Notes here", studentLoan.getNotes());
    }

    @Test
    public void testEqualsAndHashCode() {
        LocalDateTime createdAt = LocalDateTime.now();
        StudentLoan loan1 = new StudentLoan(
                1L,
                123,
                "ID12345",
                new BigDecimal("5000.00"),
                "Student Loan",
                15,
                new BigDecimal("100.00"),
                true,
                1,
                LocalDate.now(),
                new BigDecimal("5.50"),
                createdAt,
                "Notes here"
        );

        StudentLoan loan2 = new StudentLoan(
                1L,
                123,
                "ID12345",
                new BigDecimal("5000.00"),
                "Student Loan",
                15,
                new BigDecimal("100.00"),
                true,
                1,
                LocalDate.now(),
                new BigDecimal("5.50"),
                createdAt,
                "Notes here"
        );

        StudentLoan loan3 = new StudentLoan(
                2L,
                124,
                "ID67890",
                new BigDecimal("6000.00"),
                "Different Loan",
                20,
                new BigDecimal("200.00"),
                false,
                2,
                LocalDate.now().plusDays(1),
                new BigDecimal("6.00"),
                createdAt,
                "Different notes"
        );

        assertEquals(loan1, loan2);
        assertNotEquals(loan1, loan3);
        assertEquals(loan1.hashCode(), loan2.hashCode());
        assertNotEquals(loan1.hashCode(), loan3.hashCode());
    }

    @Test
    public void testToString() {
        LocalDateTime createdAt = LocalDateTime.now();
        StudentLoan studentLoan = new StudentLoan(
                1L,
                123,
                "ID12345",
                new BigDecimal("5000.00"),
                "Student Loan",
                15,
                new BigDecimal("100.00"),
                true,
                1,
                LocalDate.now(),
                new BigDecimal("5.50"),
                createdAt,
                "Notes here"
        );

        String expectedToString = "StudentLoan{" +
                "studentLoanId=" + 1L +
                ", ownerID=" + 123 +
                ", accountIdentifier='" + "ID12345" + '\'' +
                ", accountName='" + "Student Loan" + '\'' +
                ", balance=" + new BigDecimal("5000.00") +
                ", paymentDate=" + 15 +
                ", minMonthlyPayment=" + new BigDecimal("100.00") +
                ", autoPay=" + true +
                ", defaultPaymentID=" + 1 +
                ", updated=" + LocalDate.now() +
                ", apr=" + new BigDecimal("5.50") +
                ", createdAt=" + createdAt +
                ", notes='" + "Notes here" + '\'' +
                '}';

        assertEquals(expectedToString, studentLoan.toString());
    }
}
