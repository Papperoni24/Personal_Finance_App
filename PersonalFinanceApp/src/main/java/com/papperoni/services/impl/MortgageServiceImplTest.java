package com.papperoni.services.impl;

import com.papperoni.models.Mortgage;
import com.papperoni.repositories.MortgageRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class MortgageServiceImplTest {

    @Mock
    private MortgageRepo mortgageRepository;

    @InjectMocks
    private MortgageServiceImpl mortgageService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllMortgages() {
        Mortgage mortgage1 = new Mortgage();
        Mortgage mortgage2 = new Mortgage();
        List<Mortgage> mortgages = Arrays.asList(mortgage1, mortgage2);

        when(mortgageRepository.findAll()).thenReturn(mortgages);

        List<Mortgage> result = mortgageService.getAllMortgages();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(mortgageRepository, times(1)).findAll();
    }

    @Test
    public void testGetMortgageById() {
        Long id = 1L;
        Mortgage mortgage = new Mortgage();
        mortgage.setMortgageId(id);

        when(mortgageRepository.findById(id)).thenReturn(Optional.of(mortgage));

        Optional<Mortgage> result = mortgageService.getMortgageById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getMortgageId());
        verify(mortgageRepository, times(1)).findById(id);
    }

    @Test
    public void testGetMortgageByIdNotFound() {
        Long id = 2L;

        when(mortgageRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Mortgage> result = mortgageService.getMortgageById(id);

        assertFalse(result.isPresent());
        verify(mortgageRepository, times(1)).findById(id);
    }

    @Test
    public void testSaveMortgage() {
        Mortgage mortgage = new Mortgage();
        when(mortgageRepository.save(any(Mortgage.class))).thenReturn(mortgage);

        Mortgage result = mortgageService.saveMortgage(mortgage);

        assertNotNull(result);
        verify(mortgageRepository, times(1)).save(mortgage);
    }

    @Test
    public void testDeleteMortgage() {
        Long id = 3L;

        mortgageService.deleteMortgage(id);

        verify(mortgageRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateMortgage() {
        Long id = 4L;
        Mortgage existingMortgage = new Mortgage();
        existingMortgage.setMortgageId(id);
        existingMortgage.setOwnerID(1);

        Mortgage updatedDetails = new Mortgage();
        updatedDetails.setOwnerID(2);
        updatedDetails.setAccountIdentifier("New Identifier");
        updatedDetails.setAccountName("New Name");
        updatedDetails.setBalance(BigDecimal.valueOf(2000.00));
        updatedDetails.setPaymentDate(30);
        updatedDetails.setMinMonthlyPayment(BigDecimal.valueOf(150.00));
        updatedDetails.setAutoPay(true);
        updatedDetails.setDefaultPaymentID(2);
        updatedDetails.setUpdated(LocalDate.now());
        updatedDetails.setApr(BigDecimal.valueOf(3.5));
        updatedDetails.setCreatedAt(LocalDateTime.now());
        updatedDetails.setNotes("Updated notes");

        when(mortgageRepository.findById(id)).thenReturn(Optional.of(existingMortgage));
        when(mortgageRepository.save(any(Mortgage.class))).thenReturn(updatedDetails);

        Mortgage result = mortgageService.updateMortgage(id, updatedDetails);

        assertNotNull(result);
        assertEquals(2, result.getOwnerID());
        assertEquals("New Identifier", result.getAccountIdentifier());
        assertEquals("New Name", result.getAccountName());
        assertEquals(BigDecimal.valueOf(2000.00), result.getBalance());
        assertEquals(updatedDetails.getPaymentDate(), result.getPaymentDate());
        assertEquals(BigDecimal.valueOf(150.00), result.getMinMonthlyPayment());
        assertTrue(result.getAutoPay());
        assertEquals(2, result.getDefaultPaymentID());
        assertEquals(updatedDetails.getUpdated(), result.getUpdated());
        assertEquals(BigDecimal.valueOf(3.5), result.getApr());
        assertEquals(updatedDetails.getCreatedAt(), result.getCreatedAt());
        assertEquals("Updated notes", result.getNotes());

        verify(mortgageRepository, times(1)).findById(id);
        verify(mortgageRepository, times(1)).save(result);
    }
}
