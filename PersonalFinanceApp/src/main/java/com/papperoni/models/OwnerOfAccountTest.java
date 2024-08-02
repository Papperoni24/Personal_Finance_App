package com.papperoni.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerOfAccountTest {

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
    public void testValidOwnerOfAccount() {
        OwnerOfAccount owner = new OwnerOfAccount(
                1L,
                "ValidUsername",
                "valid.email@example.com",
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OwnerOfAccount>> violations = validator.validate(owner);
        assertTrue(violations.isEmpty(), "Expected no constraint violations, but got: " + violations);
    }

    @Test
    public void testUsernameTooLong() {
        OwnerOfAccount owner = new OwnerOfAccount(
                1L,
                "A".repeat(51), // Username exceeds max length of 50
                "valid.email@example.com",
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OwnerOfAccount>> violations = validator.validate(owner);
        assertEquals(1, violations.size(), "Expected 1 violation for username exceeding maximum length");
    }

    @Test
    public void testEmailTooLong() {
        OwnerOfAccount owner = new OwnerOfAccount(
                1L,
                "ValidUsername",
                "A".repeat(101) + "@example.com", // Email exceeds max length of 100
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OwnerOfAccount>> violations = validator.validate(owner);

        // Print violations for debugging
        for (ConstraintViolation<OwnerOfAccount> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }

        assertEquals(2, violations.size(), "Expected 2 violations for email: one for length and one for format");
    }


    @Test
    public void testInvalidEmail() {
        OwnerOfAccount owner = new OwnerOfAccount(
                1L,
                "ValidUsername",
                "invalid-email", // Invalid email format
                LocalDateTime.now(),
                "Valid notes"
        );

        Set<ConstraintViolation<OwnerOfAccount>> violations = validator.validate(owner);
        assertEquals(1, violations.size(), "Expected 1 violation for invalid email format");
    }

    @Test
    public void testCreatedAtInFuture() {
        OwnerOfAccount owner = new OwnerOfAccount(
                1L,
                "ValidUsername",
                "valid.email@example.com",
                LocalDateTime.now().plusDays(1), // CreatedAt is in the future
                "Valid notes"
        );

        Set<ConstraintViolation<OwnerOfAccount>> violations = validator.validate(owner);
        assertEquals(1, violations.size(), "Expected 1 violation for createdAt being in the future");
    }

    @Test
    public void testNotesTooLong() {
        String longNotes = "Test notes that exceed the maximum length of 255 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Vestibulum vehicula ex eu massa auctor, in elementum ligula posuere. " +
                "Donec auctor dapibus metus, id scelerisque risus consequat sed. " +
                "Proin ac nisl sed elit sodales pharetra. Morbi ut feugiat felis. " +
                "Nullam vel turpis augue.";

        OwnerOfAccount owner = new OwnerOfAccount(
                1L,
                "ValidUsername",
                "valid.email@example.com",
                LocalDateTime.now(),
                longNotes // Notes exceed the maximum length of 255 characters
        );

        Set<ConstraintViolation<OwnerOfAccount>> violations = validator.validate(owner);
        assertEquals(1, violations.size(), "Expected 1 violation for notes exceeding maximum length");
    }
}
