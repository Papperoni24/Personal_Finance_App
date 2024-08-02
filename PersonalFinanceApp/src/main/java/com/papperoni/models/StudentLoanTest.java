package com.papperoni.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentLoanTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterEach
    public void tearDown() {
        validator = null;
    }

    @Test
    public void testValidStudentLoan() {
        StudentLoan loan = new StudentLoan(
                1L,
                new OwnerOfAccount(), // Assuming you have a default or mock implementation
                "ValidIdentifier",
                new BigDecimal("5000.00"),
                "Valid Account Name",
                15, // PaymentDate
                new BigDecimal("150.00"),
                true,
                "ValidAccount",
                LocalDate.now(),
                new BigDecimal("3.75"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<StudentLoan>> violations = validator.validate(loan);
        assertEquals(0, violations.size(), "Expected no constraint violations for valid student loan");
    }

    @Test
    public void testAccountIdentifierBlank() {
        StudentLoan loan = new StudentLoan(
                1L,
                new OwnerOfAccount(),
                "", // Account identifier is blank
                new BigDecimal("5000.00"),
                "Valid Account Name",
                15,
                new BigDecimal("150.00"),
                true,
                "ValidAccount",
                LocalDate.now(),
                new BigDecimal("3.75"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<StudentLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for blank account identifier");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("accountIdentifier")), "Expected violation on 'accountIdentifier' field");
    }

    @Test
    public void testAccountIdentifierTooLong() {
        StudentLoan loan = new StudentLoan(
                1L,
                new OwnerOfAccount(),
                "A".repeat(101), // Exceeds max length of 100
                new BigDecimal("5000.00"),
                "Valid Account Name",
                15,
                new BigDecimal("150.00"),
                true,
                "ValidAccount",
                LocalDate.now(),
                new BigDecimal("3.75"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<StudentLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for account identifier exceeding maximum length");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("accountIdentifier")), "Expected violation on 'accountIdentifier' field");
    }

    @Test
    public void testAccountNameTooLong() {
        StudentLoan loan = new StudentLoan(
                1L,
                new OwnerOfAccount(),
                "ValidIdentifier",
                new BigDecimal("5000.00"),
                "A".repeat(101), // Exceeds max length of 100
                15,
                new BigDecimal("150.00"),
                true,
                "ValidAccount",
                LocalDate.now(),
                new BigDecimal("3.75"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<StudentLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for account name exceeding maximum length");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("accountName")), "Expected violation on 'accountName' field");
    }

    @Test
    public void testBalanceNegative() {
        StudentLoan loan = new StudentLoan(
                1L,
                new OwnerOfAccount(),
                "ValidIdentifier",
                new BigDecimal("-100.00"), // Negative balance
                "Valid Account Name",
                15,
                new BigDecimal("150.00"),
                true,
                "ValidAccount",
                LocalDate.now(),
                new BigDecimal("3.75"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<StudentLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for negative balance");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("balance")), "Expected violation on 'balance' field");
    }

    @Test
    public void testBalanceNull() {
        StudentLoan loan = new StudentLoan(
                1L,
                new OwnerOfAccount(),
                "ValidIdentifier",
                null, // Balance is null
                "Valid Account Name",
                15,
                new BigDecimal("150.00"),
                true,
                "ValidAccount",
                LocalDate.now(),
                new BigDecimal("3.75"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<StudentLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for null balance");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("balance")), "Expected violation on 'balance' field");
    }

    @Test
    public void testUpdatedNull() {
        StudentLoan loan = new StudentLoan(
                1L,
                new OwnerOfAccount(),
                "ValidIdentifier",
                new BigDecimal("5000.00"),
                "Valid Account Name",
                15,
                new BigDecimal("150.00"),
                true,
                "ValidAccount",
                null, // Updated is null
                new BigDecimal("3.75"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<StudentLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for null updated date");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("updated")), "Expected violation on 'updated' field");
    }

    @Test
    public void testCreatedAtNull() {
        StudentLoan loan = new StudentLoan(
                1L,
                new OwnerOfAccount(),
                "ValidIdentifier",
                new BigDecimal("5000.00"),
                "Valid Account Name",
                15,
                new BigDecimal("150.00"),
                true,
                "ValidAccount",
                LocalDate.now(),
                new BigDecimal("3.75"),
                null, // CreatedAt is null
                "Valid notes"
        );

        Set<ConstraintViolation<StudentLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for null createdAt");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("createdAt")), "Expected violation on 'createdAt' field");
    }

    @Test
    public void testNotesTooLong() {
        StudentLoan loan = new StudentLoan(
                1L,
                new OwnerOfAccount(),
                "ValidIdentifier",
                new BigDecimal("5000.00"),
                "Valid Account Name",
                15,
                new BigDecimal("150.00"),
                true,
                "ValidAccount",
                LocalDate.now(),
                new BigDecimal("3.75"),
                LocalDateTime.now(),
                "A".repeat(256) // Exceeds max length of 255
        );

        Set<ConstraintViolation<StudentLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for notes exceeding maximum length");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("notes")), "Expected violation on 'notes' field");
    }
}

