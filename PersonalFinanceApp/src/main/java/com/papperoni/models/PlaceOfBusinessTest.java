import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.papperoni.models.PlaceOfBusiness;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class PlaceOfBusinessTest {

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
    public void testValidPlaceOfBusiness() {
        PlaceOfBusiness place = new PlaceOfBusiness(
                1L,
                "Valid Business Name",
                "Valid Payment Method",
                "Some notes about the business"
        );

        Set<ConstraintViolation<PlaceOfBusiness>> violations = validator.validate(place);
        assertTrue(violations.isEmpty(), "Expected no constraint violations");
    }

    @Test
    public void testNameBlank() {
        PlaceOfBusiness place = new PlaceOfBusiness(
                1L,
                "", // Name is blank
                "Valid Payment Method",
                "Some notes about the business"
        );

        Set<ConstraintViolation<PlaceOfBusiness>> violations = validator.validate(place);
        assertEquals(1, violations.size(), "Expected 1 violation for blank name");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("name")), "Expected violation on 'name' field");
    }

    @Test
    public void testDefaultPaymentTooLong() {
        PlaceOfBusiness place = new PlaceOfBusiness(
                1L,
                "Valid Business Name",
                "A".repeat(101), // DefaultPayment exceeds max length of 100
                "Some notes about the business"
        );

        Set<ConstraintViolation<PlaceOfBusiness>> violations = validator.validate(place);
        assertEquals(1, violations.size(), "Expected 1 violation for default payment exceeding maximum length");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("defaultPayment")), "Expected violation on 'defaultPayment' field");
    }

    @Test
    public void testNotesTooLong() {
        PlaceOfBusiness place = new PlaceOfBusiness(
                1L,
                "Valid Business Name",
                "Valid Payment Method",
                "A".repeat(256) // Notes exceed max length of 255
        );

        Set<ConstraintViolation<PlaceOfBusiness>> violations = validator.validate(place);
        assertEquals(1, violations.size(), "Expected 1 violation for notes exceeding maximum length");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("notes")), "Expected violation on 'notes' field");
    }

    @Test
    public void testAllFieldsNull() {
        PlaceOfBusiness place = new PlaceOfBusiness(
                null,
                null, // Name is null
                null,
                null
        );

        Set<ConstraintViolation<PlaceOfBusiness>> violations = validator.validate(place);
        assertEquals(1, violations.size(), "Expected 1 violation for null name");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("name")), "Expected violation on 'name' field");
    }
}

