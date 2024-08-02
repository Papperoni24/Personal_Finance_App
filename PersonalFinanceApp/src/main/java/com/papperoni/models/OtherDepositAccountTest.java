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

public class OtherDepositAccountTest {

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
    public void testValidOtherDepositAccount() {
        OtherDepositAccount account = new OtherDepositAccount(
                1L,
                "ValidAccountID",
                new OwnerOfAccount(), // Assume OwnerOfAccount is valid
                "Valid Account Name",
                new BigDecimal("1500.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OtherDepositAccount>> violations = validator.validate(account);
        assertTrue(violations.isEmpty(), "Expected no constraint violations, but got: " + violations);
    }

    @Test
    public void testNullOwner() {
        OtherDepositAccount account = new OtherDepositAccount(
                1L,
                "ValidAccountID",
                null, // Owner is null
                "Valid Account Name",
                new BigDecimal("1500.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OtherDepositAccount>> violations = validator.validate(account);
        assertEquals(0, violations.size(), "Expected no violations for null owner");
    }

    @Test
    public void testAccountIdentifierTooLong() {
        OtherDepositAccount account = new OtherDepositAccount(
                1L,
                "A".repeat(101), // Account identifier exceeds max length
                new OwnerOfAccount(),
                "Valid Account Name",
                new BigDecimal("1500.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OtherDepositAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for account identifier exceeding maximum length");
    }

    @Test
    public void testAccountNameTooLong() {
        OtherDepositAccount account = new OtherDepositAccount(
                1L,
                "ValidAccountID",
                new OwnerOfAccount(),
                "A".repeat(101), // Account name exceeds max length
                new BigDecimal("1500.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OtherDepositAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for account name exceeding maximum length");
    }

    @Test
    public void testNotesTooLong() {
        String longNotes = "Test notes that exceed the maximum length of 255 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Vestibulum vehicula ex eu massa auctor, in elementum ligula posuere. " +
                "Donec auctor dapibus metus, id scelerisque risus consequat sed. " +
                "Proin ac nisl sed elit sodales pharetra. Morbi ut feugiat felis. " +
                "Nullam vel turpis augue.";

        OtherDepositAccount account = new OtherDepositAccount(
                1L,
                "ValidAccountID",
                new OwnerOfAccount(),
                "Valid Account Name",
                new BigDecimal("1500.00"),
                LocalDateTime.now(),
                longNotes // Notes exceed the maximum length
        );

        Set<ConstraintViolation<OtherDepositAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for notes exceeding maximum length");
    }

    @Test
    public void testBalanceNull() {
        OtherDepositAccount account = new OtherDepositAccount(
                1L,
                "ValidAccountID",
                new OwnerOfAccount(),
                "Valid Account Name",
                null, // Balance is null
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OtherDepositAccount>> violations = validator.validate(account);
        assertEquals(0, violations.size(), "Expected no violations for null balance");
    }

    @Test
    public void testDefaultCreatedAt() {
        OtherDepositAccount account = new OtherDepositAccount(
                1L,
                "ValidAccountID",
                new OwnerOfAccount(),
                "Valid Account Name",
                new BigDecimal("1500.00"),
                null, // CreatedAt is null
                "Valid notes"
        );

        Set<ConstraintViolation<OtherDepositAccount>> violations = validator.validate(account);
        assertEquals(0, violations.size(), "Expected no violations for null createdAt");
    }
}

