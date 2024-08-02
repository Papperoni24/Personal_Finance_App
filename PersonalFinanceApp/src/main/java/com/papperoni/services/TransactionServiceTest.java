package com.papperoni.services;

import com.papperoni.models.Transaction;
import com.papperoni.repositories.TransactionRepo;
import com.papperoni.services.impl.TransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {

    @Mock
    private TransactionRepo transactionRepo;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveTransaction() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setDescription("Test Transaction");

        when(transactionRepo.save(transaction)).thenReturn(transaction);

        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        assertEquals(new BigDecimal("100.00"), savedTransaction.getAmount());
        assertEquals("Test Transaction", savedTransaction.getDescription());

        verify(transactionRepo, times(1)).save(transaction);
    }

    @Test
    public void testGetTransactionById() {
        int id = 1;
        Transaction transaction = new Transaction();
        transaction.setTransactionId(id);

        when(transactionRepo.findById(id)).thenReturn(Optional.of(transaction));

        Optional<Transaction> foundTransaction = transactionService.getTransactionById(id);
        assertTrue(foundTransaction.isPresent());
        assertEquals(id, foundTransaction.get().getTransactionID());

        verify(transactionRepo, times(1)).findById(id);
    }

    @Test
    void testGetTransactionID() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1);
        assertEquals(1, transaction.getTransactionID());
    }

    @Test
    void testSetTransactionID() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1);
        assertEquals(1, transaction.getTransactionID());
    }

    @Test
    void testSetAmount() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("100.00"));
        assertEquals(new BigDecimal("100.00"), transaction.getAmount());
    }

    @Test
    void testGetDescription() {
        Transaction transaction = new Transaction();
        transaction.setDescription("Test Description");
        assertEquals("Test Description", transaction.getDescription());
    }

    @Test
    void testSetDescription() {
        Transaction transaction = new Transaction();
        transaction.setDescription("Test Description");
        assertEquals("Test Description", transaction.getDescription());
    }

    @Test
    void testGetAccountId() {
        Transaction transaction = new Transaction();
        transaction.setAccountId(1);
        assertEquals(1, transaction.getAccountId());
    }

    @Test
    void testSetAccountId() {
        Transaction transaction = new Transaction();
        transaction.setAccountId(1);
        assertEquals(1, transaction.getAccountId());
    }


    @Test
    void testGetTransactionDate() {
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(date);
        assertEquals(date, transaction.getTransactionDate());
    }

    @Test
    void testSetTransactionDate() {
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(date);
        assertEquals(date, transaction.getTransactionDate());
    }

    @Test
    void testGetUploadDate() {
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction();
        transaction.setUploadDate(date);
        assertEquals(date, transaction.getUploadDate());
    }

    @Test
    void testSetUploadDate() {
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction();
        transaction.setUploadDate(date);
        assertEquals(date, transaction.getUploadDate());
    }

    @Test
    void testGetLastUpdated() {
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction();
        transaction.setLastUpdated(date);
        assertEquals(date, transaction.getLastUpdated());
    }

    @Test
    void testSetLastUpdated() {
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction();
        transaction.setLastUpdated(date);
        assertEquals(date, transaction.getLastUpdated());
    }

    @Test
    void testEquals() {
        Transaction transaction1 = new Transaction();
        transaction1.setAccountId(1);

        Transaction transaction2 = new Transaction();
        transaction2.setAccountId(1);

        assertEquals(transaction1, transaction2);
    }

    @Test
    void testToString() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1);
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setDescription("Test Description");
        transaction.setAccountId(2);
        transaction.setPlaceOfBusiness(null);
        transaction.setTransactionType(null);
        transaction.setAssociatedAccountId(3);
        transaction.setAssociatedAccountType(null);
        transaction.setTransactionDate(LocalDateTime.of(2024, 8, 1, 10, 30));
        transaction.setUploadDate(LocalDateTime.of(2024, 7, 31, 9, 15));
        transaction.setLastUpdated(LocalDateTime.of(2024, 8, 1, 12, 45));
        transaction.setIsRecurring(null);

        String expected = "Transaction{" +
                "transactionId=1" +
                ", amount=100.00" +
                ", description='Test Description'" +
                ", accountId=2" +
                ", placeOfBusiness=null" +
                ", transactionType=null" +
                ", associatedAccountId=3" +
                ", associatedAccountType=null" +
                ", transactionDate=2024-08-01T10:30:00" +
                ", uploadDate=2024-07-31T09:15:00" +
                ", lastUpdated=2024-08-01T12:45:00" +
                ", isRecurring=null" +
                '}';

        assertEquals(expected, transaction.toString());
    }


}
