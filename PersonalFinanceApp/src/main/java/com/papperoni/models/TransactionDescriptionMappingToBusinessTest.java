package com.papperoni.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionDescriptionMappingToBusinessTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidTransactionDescriptionMapping() {
        TransactionDescriptionMappingToBusiness transactionDescriptionMapping = new TransactionDescriptionMappingToBusiness(
                1L, "Test Description", 123, "Some notes"
        );

        Set<ConstraintViolation<TransactionDescriptionMappingToBusiness>> violations = validator.validate(transactionDescriptionMapping);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testDescriptionNotBlank() {
        TransactionDescriptionMappingToBusiness transactionDescriptionMapping = new TransactionDescriptionMappingToBusiness(
                1L, "", 123, "Some notes"
        );

        Set<ConstraintViolation<TransactionDescriptionMappingToBusiness>> violations = validator.validate(transactionDescriptionMapping);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("Description is required", violations.iterator().next().getMessage());
    }

    @Test
    public void testDescriptionMaxSize() {
        String longDescription = "a".repeat(256);
        TransactionDescriptionMappingToBusiness transactionDescriptionMapping = new TransactionDescriptionMappingToBusiness(
                1L, longDescription, 123, "Some notes"
        );

        Set<ConstraintViolation<TransactionDescriptionMappingToBusiness>> violations = validator.validate(transactionDescriptionMapping);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("Description cannot exceed 255 characters", violations.iterator().next().getMessage());
    }

    @Test
    public void testNotesMaxSize() {
        String longNotes = "a".repeat(256);
        TransactionDescriptionMappingToBusiness transactionDescriptionMapping = new TransactionDescriptionMappingToBusiness(
                1L, "Test Description", 123, longNotes
        );

        Set<ConstraintViolation<TransactionDescriptionMappingToBusiness>> violations = validator.validate(transactionDescriptionMapping);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("Notes cannot exceed 255 characters", violations.iterator().next().getMessage());
    }

    @Test
    public void testEqualsAndHashCode() {
        TransactionDescriptionMappingToBusiness mapping1 = new TransactionDescriptionMappingToBusiness(
                1L, "Description1", 123, "Notes1"
        );

        TransactionDescriptionMappingToBusiness mapping2 = new TransactionDescriptionMappingToBusiness(
                1L, "Description1", 123, "Notes1"
        );

        assertEquals(mapping1, mapping2);
        assertEquals(mapping1.hashCode(), mapping2.hashCode());
    }

    @Test
    public void testToString() {
        TransactionDescriptionMappingToBusiness transactionDescriptionMapping = new TransactionDescriptionMappingToBusiness(
                1L, "Test Description", 123, "Some notes"
        );

        String expectedToString = "TransactionDescriptionMappingToBusiness{transactionDescriptionId=1, description='Test Description', placeOfBusinessID=123, notes='Some notes'}";
        assertEquals(expectedToString, transactionDescriptionMapping.toString());
    }
}

