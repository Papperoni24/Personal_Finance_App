package com.papperoni.services.impl;

import com.papperoni.models.CheckingAccount;
import com.papperoni.repositories.CheckingAccountRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CheckingAccountServiceImplTest {

    @Mock
    private CheckingAccountRepo checkingAccountRepo;

    @InjectMocks
    private CheckingAccountServiceImpl checkingAccountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        CheckingAccount account1 = new CheckingAccount();
        CheckingAccount account2 = new CheckingAccount();
        List<CheckingAccount> checkingAccounts = Arrays.asList(account1, account2);

        when(checkingAccountRepo.findAll()).thenReturn(checkingAccounts);

        List<CheckingAccount> result = checkingAccountService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(checkingAccountRepo, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setCheckingId(id);

        when(checkingAccountRepo.findById(id)).thenReturn(Optional.of(checkingAccount));

        CheckingAccount result = checkingAccountService.findById(id);

        assertNotNull(result);
        assertEquals(id, result.getCheckingId());
        verify(checkingAccountRepo, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        Long id = 2L;

        when(checkingAccountRepo.findById(id)).thenReturn(Optional.empty());

        CheckingAccount result = checkingAccountService.findById(id);

        assertNull(result);
        verify(checkingAccountRepo, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        CheckingAccount checkingAccount = new CheckingAccount();
        when(checkingAccountRepo.save(any(CheckingAccount.class))).thenReturn(checkingAccount);

        CheckingAccount result = checkingAccountService.save(checkingAccount);

        assertNotNull(result);
        verify(checkingAccountRepo, times(1)).save(checkingAccount);
    }

    @Test
    public void testDeleteById() {
        Long id = 3L;

        checkingAccountService.deleteById(id);

        verify(checkingAccountRepo, times(1)).deleteById(id);
    }
}

