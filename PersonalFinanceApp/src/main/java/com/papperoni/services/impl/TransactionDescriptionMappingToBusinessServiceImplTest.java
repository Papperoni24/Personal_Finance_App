package com.papperoni.services.impl;

import com.papperoni.models.TransactionDescriptionMappingToBusiness;
import com.papperoni.repositories.TransactionDescriptionMappingToBusinessRepo;
import com.papperoni.services.TransactionDescriptionMappingToBusinessService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionDescriptionMappingToBusinessServiceImplTest {

    @Mock
    private TransactionDescriptionMappingToBusinessRepo transactionDescriptionMappingToBusinessRepo;

    @InjectMocks
    private TransactionDescriptionMappingToBusinessServiceImpl transactionDescriptionMappingToBusinessService;

    private TransactionDescriptionMappingToBusiness mapping1;
    private TransactionDescriptionMappingToBusiness mapping2;

    @BeforeEach
    public void setUp() {
        mapping1 = new TransactionDescriptionMappingToBusiness(1L, "Description1", 123, "Notes1");
        mapping2 = new TransactionDescriptionMappingToBusiness(2L, "Description2", 456, "Notes2");
    }

    @Test
    public void testGetAllTransactionDescriptionMappings() {
        when(transactionDescriptionMappingToBusinessRepo.findAll()).thenReturn(Arrays.asList(mapping1, mapping2));

        List<TransactionDescriptionMappingToBusiness> mappings = transactionDescriptionMappingToBusinessService.getAllTransactionDescriptionMappings();
        assertEquals(2, mappings.size());
        assertEquals(mapping1, mappings.get(0));
        assertEquals(mapping2, mappings.get(1));

        verify(transactionDescriptionMappingToBusinessRepo, times(1)).findAll();
    }

    @Test
    public void testGetTransactionDescriptionMappingById() {
        when(transactionDescriptionMappingToBusinessRepo.findById(1L)).thenReturn(Optional.of(mapping1));

        Optional<TransactionDescriptionMappingToBusiness> mapping = transactionDescriptionMappingToBusinessService.getTransactionDescriptionMappingById(1L);
        assertTrue(mapping.isPresent());
        assertEquals(mapping1, mapping.get());

        verify(transactionDescriptionMappingToBusinessRepo, times(1)).findById(1L);
    }

    @Test
    public void testSaveTransactionDescriptionMapping() {
        when(transactionDescriptionMappingToBusinessRepo.save(any(TransactionDescriptionMappingToBusiness.class))).thenReturn(mapping1);

        TransactionDescriptionMappingToBusiness savedMapping = transactionDescriptionMappingToBusinessService.saveTransactionDescriptionMapping(mapping1);
        assertEquals(mapping1, savedMapping);

        ArgumentCaptor<TransactionDescriptionMappingToBusiness> captor = ArgumentCaptor.forClass(TransactionDescriptionMappingToBusiness.class);
        verify(transactionDescriptionMappingToBusinessRepo, times(1)).save(captor.capture());
        assertEquals(mapping1, captor.getValue());
    }

    @Test
    public void testDeleteTransactionDescriptionMapping() {
        doNothing().when(transactionDescriptionMappingToBusinessRepo).deleteById(1L);

        transactionDescriptionMappingToBusinessService.deleteTransactionDescriptionMapping(1L);
        verify(transactionDescriptionMappingToBusinessRepo, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateTransactionDescriptionMapping() {
        when(transactionDescriptionMappingToBusinessRepo.findById(1L)).thenReturn(Optional.of(mapping1));
        when(transactionDescriptionMappingToBusinessRepo.save(any(TransactionDescriptionMappingToBusiness.class))).thenReturn(mapping1);

        TransactionDescriptionMappingToBusiness updatedDetails = new TransactionDescriptionMappingToBusiness(null, "Updated Description", 789, "Updated Notes");
        TransactionDescriptionMappingToBusiness updatedMapping = transactionDescriptionMappingToBusinessService.updateTransactionDescriptionMapping(1L, updatedDetails);

        assertEquals("Updated Description", updatedMapping.getDescription());
        assertEquals(789, updatedMapping.getPlaceOfBusinessID());
        assertEquals("Updated Notes", updatedMapping.getNotes());

        verify(transactionDescriptionMappingToBusinessRepo, times(1)).findById(1L);
        verify(transactionDescriptionMappingToBusinessRepo, times(1)).save(any(TransactionDescriptionMappingToBusiness.class));
    }

    @Test
    public void testUpdateTransactionDescriptionMappingNotFound() {
        when(transactionDescriptionMappingToBusinessRepo.findById(1L)).thenReturn(Optional.empty());

        TransactionDescriptionMappingToBusiness updatedDetails = new TransactionDescriptionMappingToBusiness(null, "Updated Description", 789, "Updated Notes");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            transactionDescriptionMappingToBusinessService.updateTransactionDescriptionMapping(1L, updatedDetails);
        });

        assertEquals("TransactionDescriptionMappingToBusiness not found", exception.getMessage());
        verify(transactionDescriptionMappingToBusinessRepo, times(1)).findById(1L);
        verify(transactionDescriptionMappingToBusinessRepo, never()).save(any(TransactionDescriptionMappingToBusiness.class));
    }
}
