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
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionTest {

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
    public void testValidTransaction() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setDescription("Sample Transaction");
        transaction.setAccountId(1);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setUploadDate(LocalDateTime.now());
        transaction.setLastUpdated(LocalDateTime.now());
        transaction.setIsRecurring(false);

        Set<ConstraintViolation<Transaction>> violations = validator.validate(transaction);
        assertEquals(0, violations.size(), "Expected no constraint violations for valid transaction");
    }

    @Test
    public void testAmountNull() {
        Transaction transaction = new Transaction();
        transaction.setAmount(null); // Amount is null
        transaction.setDescription("Sample Transaction");
        transaction.setAccountId(1);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setUploadDate(LocalDateTime.now());
        transaction.setLastUpdated(LocalDateTime.now());
        transaction.setIsRecurring(false);

        Set<ConstraintViolation<Transaction>> violations = validator.validate(transaction);
        assertEquals(1, violations.size(), "Expected 1 violation for null amount");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("amount")), "Expected violation on 'amount' field");
    }

    @Test
    public void testAccountIdNull() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setDescription("Sample Transaction");
        transaction.setAccountId(null); // AccountId is null
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setUploadDate(LocalDateTime.now());
        transaction.setLastUpdated(LocalDateTime.now());
        transaction.setIsRecurring(false);

        Set<ConstraintViolation<Transaction>> violations = validator.validate(transaction);
        assertEquals(1, violations.size(), "Expected 1 violation for null accountId");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("accountId")), "Expected violation on 'accountId' field");
    }

    @Test
    public void testTransactionDateNull() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setDescription("Sample Transaction");
        transaction.setAccountId(1);
        transaction.setTransactionDate(null); // TransactionDate is null
        transaction.setUploadDate(LocalDateTime.now());
        transaction.setLastUpdated(LocalDateTime.now());
        transaction.setIsRecurring(false);

        Set<ConstraintViolation<Transaction>> violations = validator.validate(transaction);
        assertEquals(1, violations.size(), "Expected 1 violation for null transactionDate");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("transactionDate")), "Expected violation on 'transactionDate' field");
    }

    @Test
    public void testUploadDateNull() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setDescription("Sample Transaction");
        transaction.setAccountId(1);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setUploadDate(null); // UploadDate is null
        transaction.setLastUpdated(LocalDateTime.now());
        transaction.setIsRecurring(false);

        Set<ConstraintViolation<Transaction>> violations = validator.validate(transaction);
        assertEquals(1, violations.size(), "Expected 1 violation for null uploadDate");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("uploadDate")), "Expected violation on 'uploadDate' field");
    }

    @Test
    public void testUpdateLastUpdatedOnPreUpdate() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setDescription("Sample Transaction");
        transaction.setAccountId(1);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setUploadDate(LocalDateTime.now());

        // Simulate update
        transaction.onUpdate();

        LocalDateTime updatedLastUpdated = transaction.getLastUpdated();
        assertEquals(LocalDateTime.now().toLocalDate(), updatedLastUpdated.toLocalDate(), "Expected lastUpdated to be updated to the current date");
    }

    @Test
    public void testToString() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1);
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setDescription("Sample Transaction");
        transaction.setAccountId(1);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setUploadDate(LocalDateTime.now());
        transaction.setLastUpdated(LocalDateTime.now());
        transaction.setIsRecurring(false);

        String expectedToString = "Transaction{" +
                "transactionId=1" +
                ", amount=100.00" +
                ", description='Sample Transaction'" +
                ", accountId=1" +
                ", placeOfBusiness=null" +
                ", transactionType=null" +
                ", associatedAccountId=null" +
                ", associatedAccountType=null" +
                ", transactionDate=" + transaction.getTransactionDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")) +
                ", uploadDate=" + transaction.getUploadDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")) +
                ", lastUpdated=" + transaction.getLastUpdated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")) +
                ", isRecurring=false" +
                '}';

        assertEquals(expectedToString, transaction.toString(), "Expected toString to return the correct string representation");
    }
}
