package com.papperoni.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SavingsAccountTest {

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
    public void testValidSavingsAccount() {
        SavingsAccount account = new SavingsAccount(
                1L,
                "ValidIdentifier",
                "Valid Account Name",
                new BigDecimal("1000.00"),
                new OwnerOfAccount(), // Assuming you have a default or mock implementation
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<SavingsAccount>> violations = validator.validate(account);
        assertEquals(0, violations.size(), "Expected no constraint violations for valid savings account");
    }

    @Test
    public void testAccountIdentifierTooLong() {
        SavingsAccount account = new SavingsAccount(
                1L,
                "A".repeat(101), // Exceeds max length of 100
                "Valid Account Name",
                new BigDecimal("1000.00"),
                new OwnerOfAccount(),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<SavingsAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for account identifier exceeding maximum length");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("accountIdentifier")), "Expected violation on 'accountIdentifier' field");
    }

    @Test
    public void testAccountNameTooLong() {
        SavingsAccount account = new SavingsAccount(
                1L,
                "ValidIdentifier",
                "A".repeat(101), // Exceeds max length of 100
                new BigDecimal("1000.00"),
                new OwnerOfAccount(),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<SavingsAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for account name exceeding maximum length");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("accountName")), "Expected violation on 'accountName' field");
    }

    @Test
    public void testBalanceNegative() {
        SavingsAccount account = new SavingsAccount(
                1L,
                "ValidIdentifier",
                "Valid Account Name",
                new BigDecimal("-1.00"), // Negative balance
                new OwnerOfAccount(),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<SavingsAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for negative balance");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("balance")), "Expected violation on 'balance' field");
    }

    @Test
    public void testBalanceNull() {
        SavingsAccount account = new SavingsAccount(
                1L,
                "ValidIdentifier",
                "Valid Account Name",
                null, // Balance is null
                new OwnerOfAccount(),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<SavingsAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for null balance");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("balance")), "Expected violation on 'balance' field");
    }

    @Test
    public void testCreatedAtNull() {
        SavingsAccount account = new SavingsAccount(
                1L,
                "ValidIdentifier",
                "Valid Account Name",
                new BigDecimal("1000.00"),
                new OwnerOfAccount(),
                null, // CreatedAt is null
                "Valid notes"
        );

        Set<ConstraintViolation<SavingsAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for null createdAt");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("createdAt")), "Expected violation on 'createdAt' field");
    }

    @Test
    public void testNotesTooLong() {
        SavingsAccount account = new SavingsAccount(
                1L,
                "ValidIdentifier",
                "Valid Account Name",
                new BigDecimal("1000.00"),
                new OwnerOfAccount(),
                LocalDateTime.now(),
                "A".repeat(256) // Exceeds max length of 255
        );

        Set<ConstraintViolation<SavingsAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for notes exceeding maximum length");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("notes")), "Expected violation on 'notes' field");
    }
}

