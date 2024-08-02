package com.papperoni.models;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TransDescMappingToBizTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidTransDescMappingToBiz() {
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness(); // Assuming a default or mock PlaceOfBusiness
        TransDescMappingToBiz transDescMapping = new TransDescMappingToBiz(
                1L, "Sample Description", placeOfBusiness, "Sample Notes"
        );

        Set<ConstraintViolation<TransDescMappingToBiz>> violations = validator.validate(transDescMapping);
        assertTrue(violations.isEmpty(), "Expected no validation violations for valid TransDescMappingToBiz");
    }

    @Test
    public void testDescriptionNotBlank() {
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness();
        TransDescMappingToBiz transDescMapping = new TransDescMappingToBiz(
                1L, "", placeOfBusiness, "Sample Notes"
        );

        Set<ConstraintViolation<TransDescMappingToBiz>> violations = validator.validate(transDescMapping);
        assertEquals(1, violations.size(), "Expected 1 violation for blank description");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("description")), "Expected violation on 'description' field");
    }

    @Test
    public void testDescriptionSize() {
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness();
        String longDescription = "a".repeat(256); // 256 characters long
        TransDescMappingToBiz transDescMapping = new TransDescMappingToBiz(
                1L, longDescription, placeOfBusiness, "Sample Notes"
        );

        Set<ConstraintViolation<TransDescMappingToBiz>> violations = validator.validate(transDescMapping);
        assertEquals(1, violations.size(), "Expected 1 violation for description exceeding 255 characters");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("description")), "Expected violation on 'description' field");
    }

    @Test
    public void testNotesSize() {
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness();
        String longNotes = "a".repeat(256); // 256 characters long
        TransDescMappingToBiz transDescMapping = new TransDescMappingToBiz(
                1L, "Sample Description", placeOfBusiness, longNotes
        );

        Set<ConstraintViolation<TransDescMappingToBiz>> violations = validator.validate(transDescMapping);
        assertEquals(1, violations.size(), "Expected 1 violation for notes exceeding 255 characters");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("notes")), "Expected violation on 'notes' field");
    }

    @Test
    public void testEqualsAndHashCode() {
        PlaceOfBusiness placeOfBusiness1 = new PlaceOfBusiness();
        PlaceOfBusiness placeOfBusiness2 = new PlaceOfBusiness();
        TransDescMappingToBiz transDescMapping1 = new TransDescMappingToBiz(1L, "Sample Description", placeOfBusiness1, "Sample Notes");
        TransDescMappingToBiz transDescMapping2 = new TransDescMappingToBiz(1L, "Sample Description", placeOfBusiness1, "Sample Notes");
        TransDescMappingToBiz transDescMapping3 = new TransDescMappingToBiz(2L, "Different Description", placeOfBusiness2, "Different Notes");

        assertEquals(transDescMapping1, transDescMapping2, "TransDescMappingToBiz objects with the same ID and description should be equal");
        assertNotEquals(transDescMapping1, transDescMapping3, "TransDescMappingToBiz objects with different IDs or descriptions should not be equal");

        assertEquals(transDescMapping1.hashCode(), transDescMapping2.hashCode(), "Hashcodes should be equal for identical TransDescMappingToBiz objects");
        assertNotEquals(transDescMapping1.hashCode(), transDescMapping3.hashCode(), "Hashcodes should not be equal for different TransDescMappingToBiz objects");
    }

    @Test
    public void testToString() {
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness();
        TransDescMappingToBiz transDescMapping = new TransDescMappingToBiz(
                1L, "Sample Description", placeOfBusiness, "Sample Notes"
        );

        String expectedToString = "TransDescMappingToBiz{" +
                "transactionDescriptionId=1, " +
                "description='Sample Description', " +
                "placeOfBusiness=" + placeOfBusiness +
                ", notes='Sample Notes'" +
                "}";

        assertEquals(expectedToString, transDescMapping.toString(), "toString() should return the expected string representation");
    }

    @AfterAll
    public static void tearDown() {
        validator = null;
    }
}

