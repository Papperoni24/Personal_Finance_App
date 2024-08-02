package com.papperoni.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

public class PersonalLoanTest {

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
    public void testValidPersonalLoan() {
        OwnerOfAccount owner = new OwnerOfAccount(1L, "ValidUsername", "valid@example.com", LocalDateTime.now(), "Valid notes");

        PersonalLoan loan = new PersonalLoan(
                1L,
                owner,
                "ValidIdentifier",
                "ValidName",
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("50.00"),
                true,
                "DefaultPayment",
                LocalDate.now(),
                new BigDecimal("5.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<PersonalLoan>> violations = validator.validate(loan);
        assertTrue(violations.isEmpty(), "Expected no constraint violations");
    }

    @Test
    public void testNullOwner() {
        PersonalLoan loan = new PersonalLoan(
                1L,
                null, // Owner is null
                "ValidIdentifier",
                "ValidName",
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("50.00"),
                true,
                "DefaultPayment",
                LocalDate.now(),
                new BigDecimal("5.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<PersonalLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for null owner");
    }

    @Test
    public void testAccountIdentifierBlank() {
        OwnerOfAccount owner = new OwnerOfAccount(1L, "ValidUsername", "valid@example.com", LocalDateTime.now(), "Valid notes");

        PersonalLoan loan = new PersonalLoan(
                1L,
                owner,
                "", // Account identifier is blank
                "ValidName",
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("50.00"),
                true,
                "DefaultPayment",
                LocalDate.now(),
                new BigDecimal("5.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<PersonalLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for blank account identifier");
    }

    @Test
    public void testBalanceNegative() {
        OwnerOfAccount owner = new OwnerOfAccount(1L, "ValidUsername", "valid@example.com", LocalDateTime.now(), "Valid notes");

        PersonalLoan loan = new PersonalLoan(
                1L,
                owner,
                "ValidIdentifier",
                "ValidName",
                new BigDecimal("-1000.00"), // Negative balance
                15,
                new BigDecimal("50.00"),
                true,
                "DefaultPayment",
                LocalDate.now(),
                new BigDecimal("5.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<PersonalLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for negative balance");
    }

    @Test
    public void testPaymentDateOutOfRange() {
        OwnerOfAccount owner = new OwnerOfAccount(1L, "ValidUsername", "valid@example.com", LocalDateTime.now(), "Valid notes");

        PersonalLoan loan = new PersonalLoan(
                1L,
                owner,
                "ValidIdentifier",
                "ValidName",
                new BigDecimal("1000.00"),
                32, // Payment date out of range
                new BigDecimal("50.00"),
                true,
                "DefaultPayment",
                LocalDate.now(),
                new BigDecimal("5.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<PersonalLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for payment date out of range");
    }

    @Test
    public void testAprTooHigh() {
        OwnerOfAccount owner = new OwnerOfAccount(1L, "ValidUsername", "valid@example.com", LocalDateTime.now(), "Valid notes");

        PersonalLoan loan = new PersonalLoan(
                1L,
                owner,
                "ValidIdentifier",
                "ValidName",
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("50.00"),
                true,
                "DefaultPayment",
                LocalDate.now(),
                new BigDecimal("101.00"), // APR too high
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<PersonalLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for APR too high");
    }

    @Test
    public void testCreatedAtNull() {
        OwnerOfAccount owner = new OwnerOfAccount(1L, "ValidUsername", "valid@example.com", LocalDateTime.now(), "Valid notes");

        PersonalLoan loan = new PersonalLoan(
                1L,
                owner,
                "ValidIdentifier",
                "ValidName",
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("50.00"),
                true,
                "DefaultPayment",
                LocalDate.now(),
                new BigDecimal("5.00"),
                null, // CreatedAt is null
                "Valid notes"
        );

        Set<ConstraintViolation<PersonalLoan>> violations = validator.validate(loan);
        assertEquals(1, violations.size(), "Expected 1 violation for null createdAt");
    }
}

