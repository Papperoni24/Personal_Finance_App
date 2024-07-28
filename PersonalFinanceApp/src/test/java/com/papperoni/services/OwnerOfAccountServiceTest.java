package com.papperoni.services;

import com.papperoni.repositories.OwnerOfAccountsRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class OwnerOfAccountsServiceTest {

    @InjectMocks
    private OwnerOfAccountsService service;

    @Mock
    private OwnerOfAccountsRepo repository;

    public OwnerOfAccountsServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        service.findAll();
        verify(repository, times(1)).findAll();
    }

    // Additional tests
}
