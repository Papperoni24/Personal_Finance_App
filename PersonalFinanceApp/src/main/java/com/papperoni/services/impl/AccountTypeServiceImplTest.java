package com.papperoni.services.impl;

import com.papperoni.app.PersonalFinanceApplication;
import com.papperoni.models.AccountType;
import com.papperoni.repositories.AccountTypeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = PersonalFinanceApplication.class)
@ExtendWith(MockitoExtension.class)
public class AccountTypeServiceImplTest {

    @Mock
    private AccountTypeRepo accountTypeRepoMock;

    @InjectMocks
    private AccountTypeServiceImpl accountTypeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        accountTypeService = new AccountTypeServiceImpl(accountTypeRepoMock);
    }

    @Test
    public void testSaveAccountType() {
        AccountType accountType = new AccountType();
        accountType.setAccountTypeID(1);
        accountType.setAccountTypeName("Savings");

        when(accountTypeRepoMock.save(accountType)).thenReturn(accountType);

        AccountType savedAccountType = accountTypeService.saveAccountType(accountType);

        assertNotNull(savedAccountType);
        assertEquals(1, savedAccountType.getAccountTypeID());
        assertEquals("Savings", savedAccountType.getAccountTypeName());
        verify(accountTypeRepoMock, times(1)).save(accountType);
    }

    @Test
    public void testGetAccountTypeById() {
        AccountType accountType = new AccountType();
        accountType.setAccountTypeID(1);
        accountType.setAccountTypeName("Checking");

        when(accountTypeRepoMock.findById(1)).thenReturn(Optional.of(accountType));

        Optional<AccountType> retrievedAccountType = accountTypeService.getAccountTypeById(1);

        assertTrue(retrievedAccountType.isPresent());
        assertEquals(1, retrievedAccountType.get().getAccountTypeID());
        assertEquals("Checking", retrievedAccountType.get().getAccountTypeName());
        verify(accountTypeRepoMock, times(1)).findById(1);
    }

    @Test
    public void testGetAllAccountTypes() {
        AccountType accountType1 = new AccountType();
        accountType1.setAccountTypeID(1);
        accountType1.setAccountTypeName("Savings");

        AccountType accountType2 = new AccountType();
        accountType2.setAccountTypeID(2);
        accountType2.setAccountTypeName("Checking");

        when(accountTypeRepoMock.findAll()).thenReturn(Arrays.asList(accountType1, accountType2));

        List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();

        assertNotNull(accountTypes);
        assertEquals(2, accountTypes.size());
        assertEquals("Savings", accountTypes.get(0).getAccountTypeName());
        assertEquals("Checking", accountTypes.get(1).getAccountTypeName());
        verify(accountTypeRepoMock, times(1)).findAll();
    }

    @Test
    public void testDeleteAccountType() {
        int id = 1;

        accountTypeService.deleteAccountType(id);

        verify(accountTypeRepoMock, times(1)).deleteById(id);
    }
}

