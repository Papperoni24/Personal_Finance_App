package com.papperoni.services.impl;

import com.papperoni.models.OwnerOfAccount;
import com.papperoni.repositories.OwnerOfAccountsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class OwnerOfAccountsServiceImplTest {

    @Mock
    private OwnerOfAccountsRepo repository;

    @InjectMocks
    private OwnerOfAccountsServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        OwnerOfAccount owner1 = new OwnerOfAccount(1L, "user1", "user1@example.com", LocalDateTime.now(), "Notes 1");
        OwnerOfAccount owner2 = new OwnerOfAccount(2L, "user2", "user2@example.com", LocalDateTime.now(), "Notes 2");
        List<OwnerOfAccount> owners = Arrays.asList(owner1, owner2);

        when(repository.findAll()).thenReturn(owners);

        List<OwnerOfAccount> result = service.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(owner1, result.get(0));
        assertEquals(owner2, result.get(1));
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        OwnerOfAccount owner = new OwnerOfAccount(id, "user1", "user1@example.com", LocalDateTime.now(), "Notes 1");
        when(repository.findById(id)).thenReturn(Optional.of(owner));

        OwnerOfAccount result = service.findById(id);

        assertNotNull(result);
        assertEquals(owner, result);
        verify(repository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        OwnerOfAccount result = service.findById(id);

        assertNull(result);
        verify(repository, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        OwnerOfAccount owner = new OwnerOfAccount(1L, "user1", "user1@example.com", LocalDateTime.now(), "Notes 1");
        when(repository.save(owner)).thenReturn(owner);

        OwnerOfAccount result = service.save(owner);

        assertNotNull(result);
        assertEquals(owner, result);
        verify(repository, times(1)).save(owner);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;

        doNothing().when(repository).deleteById(id);

        service.deleteById(id);

        verify(repository, times(1)).deleteById(id);
    }
}
