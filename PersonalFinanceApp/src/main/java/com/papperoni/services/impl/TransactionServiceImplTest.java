package com.papperoni.services.impl;

import com.papperoni.app.PersonalFinanceApplication;
import com.papperoni.models.Transaction;
import com.papperoni.repositories.TransactionRepo;
import com.papperoni.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = PersonalFinanceApplication.class)
@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplTest {

    @Mock
    private TransactionRepo transactionRepoMock;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTransactions() {
        Transaction transaction1 = new Transaction();
        transaction1.setTransactionId(1);
        transaction1.setAmount(BigDecimal.valueOf(100.00));
        transaction1.setDescription("Payment");

        Transaction transaction2 = new Transaction();
        transaction2.setTransactionId(2);
        transaction2.setAmount(BigDecimal.valueOf(200.00));
        transaction2.setDescription("Refund");

        when(transactionRepoMock.findAll()).thenReturn(Arrays.asList(transaction1, transaction2));

        List<Transaction> transactions = transactionService.getAllTransactions();

        assertNotNull(transactions);
        assertEquals(2, transactions.size());
        assertEquals("Payment", transactions.get(0).getDescription());
        assertEquals("Refund", transactions.get(1).getDescription());
        verify(transactionRepoMock, times(1)).findAll();
    }

    @Test
    public void testGetTransactionById() {
        // Create a Transaction object and set its properties
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1);
        transaction.setAmount(BigDecimal.valueOf(100.00));  // amount is set as BigDecimal
        transaction.setDescription("Payment");

        // Mock the transactionRepo to return the created Transaction object
        when(transactionRepoMock.findById(1)).thenReturn(Optional.of(transaction));

        // Call the service method to get the Transaction by ID
        Optional<Transaction> retrievedTransaction = transactionService.getTransactionById(1);

        // Perform assertions to verify the correctness of the retrieved Transaction
        assertTrue(retrievedTransaction.isPresent());
        assertEquals(1, retrievedTransaction.get().getTransactionID());  // compare integer IDs
        assertEquals(BigDecimal.valueOf(100.00), retrievedTransaction.get().getAmount());  // compare BigDecimal with BigDecimal
        assertEquals("Payment", retrievedTransaction.get().getDescription());
        verify(transactionRepoMock, times(1)).findById(1);
    }


    @Test
    public void testSaveTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1);
        transaction.setAmount(BigDecimal.valueOf(100.00));
        transaction.setDescription("Payment");

        when(transactionRepoMock.save(transaction)).thenReturn(transaction);

        Transaction savedTransaction = transactionService.saveTransaction(transaction);

        assertNotNull(savedTransaction);
        assertEquals(1, savedTransaction.getTransactionID());
        assertEquals(BigDecimal.valueOf(100.00), savedTransaction.getAmount());  // Ensure BigDecimal comparison
        assertEquals("Payment", savedTransaction.getDescription());
        verify(transactionRepoMock, times(1)).save(transaction);  // Ensure consistent argument usage
    }


    @Test
    public void testDeleteTransaction() {
        int id = 1;

        transactionService.deleteTransaction(id);

        verify(transactionRepoMock, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateTransaction() {
        int id = 1;
        Transaction existingTransaction = new Transaction();
        existingTransaction.setTransactionId(id);
        existingTransaction.setAmount(BigDecimal.valueOf(100.00));
        existingTransaction.setDescription("Old Description");

        Transaction updatedTransaction = new Transaction();
        updatedTransaction.setAmount(BigDecimal.valueOf(150.00));
        updatedTransaction.setDescription("Updated Description");
        updatedTransaction.setAccountId(2);
        updatedTransaction.setPlaceOfBusiness(null);
        updatedTransaction.setTransactionType(null);
        updatedTransaction.setAssociatedAccountId(3);
        updatedTransaction.setAssociatedAccountType("New Account Type");
        updatedTransaction.setTransactionDate(LocalDate.parse("2024-01-01"));
        updatedTransaction.setIsRecurring(false);

        when(transactionRepoMock.findById(id)).thenReturn(Optional.of(existingTransaction));
        when(transactionRepoMock.save(existingTransaction)).thenReturn(existingTransaction);

        Transaction result = transactionService.updateTransaction(id, updatedTransaction);

        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(150.00), result.getAmount());
        assertEquals("Updated Description", result.getDescription());
        assertEquals(2, result.getAccountId());
        assertEquals(null, result.getPlaceOfBusiness());
        assertEquals(null, result.getTransactionType());
        assertEquals(3, result.getAssociatedAccountId());
        assertEquals("New Account Type", result.getAssociatedAccountType());
        assertEquals(LocalDate.parse("2024-01-01"), result.getTransactionDate());
        assertFalse(result.getIsRecurring());
        verify(transactionRepoMock, times(1)).findById(id);
        verify(transactionRepoMock, times(1)).save(existingTransaction);
    }

    @Test
    public void testUpdateTransaction_NotFound() {
        int id = 1;
        Transaction updatedTransaction = new Transaction();

        when(transactionRepoMock.findById(id)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            transactionService.updateTransaction(id, updatedTransaction);
        });

        assertEquals("Transaction not found with id " + id, thrown.getMessage());
        verify(transactionRepoMock, times(1)).findById(id);
        verify(transactionRepoMock, times(0)).save(any());
    }
}
