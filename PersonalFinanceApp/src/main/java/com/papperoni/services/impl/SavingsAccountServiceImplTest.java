package com.papperoni.services.impl;

import com.papperoni.models.SavingsAccount;
import com.papperoni.repositories.SavingsAccountRepo;
import com.papperoni.services.SavingsAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SavingsAccountServiceImplTest {

    @Mock
    private SavingsAccountRepo savingsAccountRepo;

    @InjectMocks
    private SavingsAccountServiceImpl savingsAccountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllSavingsAccounts() {
        SavingsAccount account1 = new SavingsAccount(1L, "ID123", "Savings Account 1", new BigDecimal("1000.00"), 1, LocalDateTime.now(), "Notes 1");
        SavingsAccount account2 = new SavingsAccount(2L, "ID456", "Savings Account 2", new BigDecimal("2000.00"), 2, LocalDateTime.now(), "Notes 2");

        when(savingsAccountRepo.findAll()).thenReturn(List.of(account1, account2));

        List<SavingsAccount> accounts = savingsAccountService.getAllSavingsAccounts();

        assertEquals(2, accounts.size());
        assertTrue(accounts.contains(account1));
        assertTrue(accounts.contains(account2));
    }

    @Test
    void testGetSavingsAccountById() {
        Long id = 1L;
        SavingsAccount account = new SavingsAccount(id, "ID123", "Savings Account", new BigDecimal("1000.00"), 1, LocalDateTime.now(), "Notes");

        when(savingsAccountRepo.findById(id)).thenReturn(Optional.of(account));

        Optional<SavingsAccount> foundAccount = savingsAccountService.getSavingsAccountById(id);

        assertTrue(foundAccount.isPresent());
        assertEquals(account, foundAccount.get());
    }

    @Test
    void testSaveSavingsAccount() {
        SavingsAccount account = new SavingsAccount(1L, "ID123", "Savings Account", new BigDecimal("1000.00"), 1, LocalDateTime.now(), "Notes");

        when(savingsAccountRepo.save(account)).thenReturn(account);

        SavingsAccount savedAccount = savingsAccountService.saveSavingsAccount(account);

        assertEquals(account, savedAccount);
        verify(savingsAccountRepo, times(1)).save(account);
    }

    @Test
    void testDeleteSavingsAccount() {
        Long id = 1L;

        doNothing().when(savingsAccountRepo).deleteById(id);

        savingsAccountService.deleteSavingsAccount(id);

        verify(savingsAccountRepo, times(1)).deleteById(id);
    }

    @Test
    void testUpdateSavingsAccount() {
        Long id = 1L;
        SavingsAccount existingAccount = new SavingsAccount(id, "ID123", "Old Account Name", new BigDecimal("1000.00"), 1, LocalDateTime.now(), "Old Notes");
        SavingsAccount updatedDetails = new SavingsAccount(null, "ID123", "New Account Name", new BigDecimal("1500.00"), 1, null, "New Notes");

        when(savingsAccountRepo.findById(id)).thenReturn(Optional.of(existingAccount));
        when(savingsAccountRepo.save(existingAccount)).thenReturn(new SavingsAccount(id, "ID123", "New Account Name", new BigDecimal("1500.00"), 1, LocalDateTime.now(), "New Notes"));

        SavingsAccount updatedAccount = savingsAccountService.updateSavingsAccount(id, updatedDetails);

        assertEquals("New Account Name", updatedAccount.getAccountName());
        assertEquals(new BigDecimal("1500.00"), updatedAccount.getBalance());
        assertEquals("New Notes", updatedAccount.getNotes());
        verify(savingsAccountRepo, times(1)).findById(id);
        verify(savingsAccountRepo, times(1)).save(existingAccount);
    }

    @Test
    void testUpdateSavingsAccount_NotFound() {
        Long id = 1L;
        SavingsAccount updatedDetails = new SavingsAccount(null, "ID123", "New Account Name", new BigDecimal("1500.00"), 1, null, "New Notes");

        when(savingsAccountRepo.findById(id)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            savingsAccountService.updateSavingsAccount(id, updatedDetails);
        });

        assertEquals("SavingsAccount not found", thrown.getMessage());
        verify(savingsAccountRepo, times(1)).findById(id);
        verify(savingsAccountRepo, never()).save(any(SavingsAccount.class));
    }
}
