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

public class OtherCreditAccountTest {

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
    public void testValidOtherCreditAccount() {
        OtherCreditAccount account = new OtherCreditAccount(
                1L,
                new OwnerOfAccount(), // Assume OwnerOfAccount is valid
                "ValidAccountID",
                "Valid Account Name",
                new BigDecimal("5000.00"),
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("100.00"),
                "Default Payment",
                false,
                LocalDate.now(),
                new BigDecimal("10.00"),
                new BigDecimal("50.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OtherCreditAccount>> violations = validator.validate(account);
        assertTrue(violations.isEmpty(), "Expected no constraint violations, but got: " + violations);
    }

    @Test
    public void testNullOwner() {
        OtherCreditAccount account = new OtherCreditAccount(
                1L,
                null, // Owner is null
                "ValidAccountID",
                "Valid Account Name",
                new BigDecimal("5000.00"),
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("100.00"),
                "Default Payment",
                false,
                LocalDate.now(),
                new BigDecimal("10.00"),
                new BigDecimal("50.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OtherCreditAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for null owner");
    }

    @Test
    public void testBlankAccountIdentifier() {
        OtherCreditAccount account = new OtherCreditAccount(
                1L,
                new OwnerOfAccount(),
                "", // Account identifier is blank
                "Valid Account Name",
                new BigDecimal("5000.00"),
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("100.00"),
                "Default Payment",
                false,
                LocalDate.now(),
                new BigDecimal("10.00"),
                new BigDecimal("50.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OtherCreditAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for blank account identifier");
    }

    @Test
    public void testNegativeCreditLimit() {
        OtherCreditAccount account = new OtherCreditAccount(
                1L,
                new OwnerOfAccount(),
                "ValidAccountID",
                "Valid Account Name",
                new BigDecimal("-5000.00"), // Negative credit limit
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("100.00"),
                "Default Payment",
                false,
                LocalDate.now(),
                new BigDecimal("10.00"),
                new BigDecimal("50.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OtherCreditAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for negative credit limit");
    }

    @Test
    public void testZeroPaymentDate() {
        OtherCreditAccount account = new OtherCreditAccount(
                1L,
                new OwnerOfAccount(),
                "ValidAccountID",
                "Valid Account Name",
                new BigDecimal("5000.00"),
                new BigDecimal("1000.00"),
                0, // Invalid payment date
                new BigDecimal("100.00"),
                "Default Payment",
                false,
                LocalDate.now(),
                new BigDecimal("10.00"),
                new BigDecimal("50.00"),
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OtherCreditAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for zero payment date");
    }

    @Test
    public void testTooLongNotes() {
        String longNotes = "Test notes that exceed the maximum length of 255 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Vestibulum vehicula ex eu massa auctor, in elementum ligula posuere. " +
                "Donec auctor dapibus metus, id scelerisque risus consequat sed. " +
                "Proin ac nisl sed elit sodales pharetra. Morbi ut feugiat felis. " +
                "Nullam vel turpis augue.";

        OtherCreditAccount account = new OtherCreditAccount(
                1L,
                new OwnerOfAccount(),
                "ValidAccountID",
                "Valid Account Name",
                new BigDecimal("5000.00"),
                new BigDecimal("1000.00"),
                15,
                new BigDecimal("100.00"),
                "Default Payment",
                false,
                LocalDate.now(),
                new BigDecimal("10.00"),
                new BigDecimal("50.00"),
                LocalDateTime.now(),
                longNotes // Notes exceed the maximum length
        );

        Set<ConstraintViolation<OtherCreditAccount>> violations = validator.validate(account);
        assertEquals(1, violations.size(), "Expected 1 violation for notes exceeding maximum length");
    }
}
