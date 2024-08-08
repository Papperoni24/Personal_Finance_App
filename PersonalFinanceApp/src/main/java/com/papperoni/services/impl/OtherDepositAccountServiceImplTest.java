package com.papperoni.services.impl;

import com.papperoni.models.OtherDepositAccount;
import com.papperoni.repositories.OtherDepositAccountRepo;
import com.papperoni.services.OtherDepositAccountService;
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

public class OtherDepositAccountServiceImplTest {

    @Mock
    private OtherDepositAccountRepo otherDepositAccountRepo;

    @InjectMocks
    private OtherDepositAccountServiceImpl otherDepositAccountService;

    private OtherDepositAccount account;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        account = new OtherDepositAccount(
                1L,
                "ID12345",
                1001,
                "Main Account",
                new BigDecimal("1500.00"),
                LocalDateTime.now(),
                "Test notes"
        );
    }

    @Test
    public void testGetAllOtherDepositAccounts() {
        when(otherDepositAccountRepo.findAll()).thenReturn(List.of(account));

        List<OtherDepositAccount> accounts = otherDepositAccountService.getAllOtherDepositAccounts();

        assertNotNull(accounts);
        assertEquals(1, accounts.size());
        assertEquals(account, accounts.get(0));

        verify(otherDepositAccountRepo, times(1)).findAll();
    }

    @Test
    public void testGetOtherDepositAccountById() {
        when(otherDepositAccountRepo.findById(1L)).thenReturn(Optional.of(account));

        Optional<OtherDepositAccount> foundAccount = otherDepositAccountService.getOtherDepositAccountById(1L);

        assertTrue(foundAccount.isPresent());
        assertEquals(account, foundAccount.get());

        verify(otherDepositAccountRepo, times(1)).findById(1L);
    }

    @Test
    public void testSaveOtherDepositAccount() {
        when(otherDepositAccountRepo.save(account)).thenReturn(account);

        OtherDepositAccount savedAccount = otherDepositAccountService.saveOtherDepositAccount(account);

        assertNotNull(savedAccount);
        assertEquals(account, savedAccount);

        verify(otherDepositAccountRepo, times(1)).save(account);
    }

    @Test
    public void testDeleteOtherDepositAccount() {
        doNothing().when(otherDepositAccountRepo).deleteById(1L);

        otherDepositAccountService.deleteOtherDepositAccount(1L);

        verify(otherDepositAccountRepo, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateOtherDepositAccount() {
        OtherDepositAccount updatedAccount = new OtherDepositAccount(
                1L,
                "ID12345",
                1001,
                "Updated Account",
                new BigDecimal("2000.00"),
                LocalDateTime.now(),
                "Updated notes"
        );

        when(otherDepositAccountRepo.findById(1L)).thenReturn(Optional.of(account));
        when(otherDepositAccountRepo.save(any(OtherDepositAccount.class))).thenReturn(updatedAccount);

        OtherDepositAccount result = otherDepositAccountService.updateOtherDepositAccount(1L, updatedAccount);

        assertNotNull(result);
        assertEquals(updatedAccount.getAccountName(), result.getAccountName());
        assertEquals(updatedAccount.getBalance(), result.getBalance());

        verify(otherDepositAccountRepo, times(1)).findById(1L);
        verify(otherDepositAccountRepo, times(1)).save(any(OtherDepositAccount.class));
    }

    @Test
    public void testUpdateOtherDepositAccountNotFound() {
        OtherDepositAccount updatedAccount = new OtherDepositAccount(
                1L,
                "ID12345",
                1001,
                "Updated Account",
                new BigDecimal("2000.00"),
                LocalDateTime.now(),
                "Updated notes"
        );

        when(otherDepositAccountRepo.findById(1L)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            otherDepositAccountService.updateOtherDepositAccount(1L, updatedAccount);
        });

        assertEquals("OtherDepositAccount not found", thrown.getMessage());

        verify(otherDepositAccountRepo, times(1)).findById(1L);
        verify(otherDepositAccountRepo, never()).save(any(OtherDepositAccount.class));
    }
}
