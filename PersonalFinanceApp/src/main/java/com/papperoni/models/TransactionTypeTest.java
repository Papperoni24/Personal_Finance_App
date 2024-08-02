package com.papperoni.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTypeTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidTransactionType() {
        TransactionType transactionType = new TransactionType(1L, "Expense", "General expenses");
        Set<ConstraintViolation<TransactionType>> violations = validator.validate(transactionType);
        assertTrue(violations.isEmpty(), "Expected no validation violations for valid TransactionType");
    }

    @Test
    public void testTypeNameNotBlank() {
        TransactionType transactionType = new TransactionType(1L, "", "Notes");
        Set<ConstraintViolation<TransactionType>> violations = validator.validate(transactionType);
        assertEquals(1, violations.size(), "Expected 1 violation for blank typeName");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("typeName")), "Expected violation on 'typeName' field");
    }

    @Test
    public void testTypeNameSize() {
        String longTypeName = "a".repeat(51); // 51 characters long
        TransactionType transactionType = new TransactionType(1L, longTypeName, "Notes");
        Set<ConstraintViolation<TransactionType>> violations = validator.validate(transactionType);
        assertEquals(1, violations.size(), "Expected 1 violation for typeName exceeding 50 characters");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("typeName")), "Expected violation on 'typeName' field");
    }

    @Test
    public void testNotesSize() {
        String longNotes = "a".repeat(256); // 256 characters long
        TransactionType transactionType = new TransactionType(1L, "Expense", longNotes);
        Set<ConstraintViolation<TransactionType>> violations = validator.validate(transactionType);
        assertEquals(1, violations.size(), "Expected 1 violation for notes exceeding 255 characters");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("notes")), "Expected violation on 'notes' field");
    }

    @Test
    public void testEqualsAndHashCode() {
        TransactionType transactionType1 = new TransactionType(1L, "Expense", "General expenses");
        TransactionType transactionType2 = new TransactionType(1L, "Expense", "General expenses");
        TransactionType transactionType3 = new TransactionType(2L, "Income", "Revenue");

        assertEquals(transactionType1, transactionType2, "TransactionType objects with same ID and typeName should be equal");
        assertNotEquals(transactionType1, transactionType3, "TransactionType objects with different IDs should not be equal");

        assertEquals(transactionType1.hashCode(), transactionType2.hashCode(), "Hashcodes should be equal for identical TransactionType objects");
        assertNotEquals(transactionType1.hashCode(), transactionType3.hashCode(), "Hashcodes should not be equal for different TransactionType objects");
    }
}
