package com.papperoni.services.impl;

import com.papperoni.models.PersonalLoan;
import com.papperoni.repositories.PersonalLoanRepo;
import com.papperoni.services.PersonalLoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PersonalLoanServiceImplTest {

    @Mock
    private PersonalLoanRepo personalLoanRepo;

    @InjectMocks
    private PersonalLoanServiceImpl personalLoanService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPersonalLoans() {
        PersonalLoan loan1 = new PersonalLoan(1L, 123, "ID1", "Loan 1", new BigDecimal("1000.00"), 15, new BigDecimal("100.00"), false, 456, LocalDate.now(), new BigDecimal("5.00"), LocalDateTime.now(), "Notes 1");
        PersonalLoan loan2 = new PersonalLoan(2L, 124, "ID2", "Loan 2", new BigDecimal("2000.00"), 20, new BigDecimal("200.00"), true, 457, LocalDate.now(), new BigDecimal("6.00"), LocalDateTime.now(), "Notes 2");
        when(personalLoanRepo.findAll()).thenReturn(Arrays.asList(loan1, loan2));

        assertIterableEquals(Arrays.asList(loan1, loan2), personalLoanService.getAllPersonalLoans());
    }

    @Test
    void testGetPersonalLoanById() {
        PersonalLoan loan = new PersonalLoan(1L, 123, "ID1", "Loan 1", new BigDecimal("1000.00"), 15, new BigDecimal("100.00"), false, 456, LocalDate.now(), new BigDecimal("5.00"), LocalDateTime.now(), "Notes 1");
        when(personalLoanRepo.findById(1L)).thenReturn(Optional.of(loan));

        assertEquals(Optional.of(loan), personalLoanService.getPersonalLoanById(1L));
    }

    @Test
    void testSavePersonalLoan() {
        PersonalLoan loan = new PersonalLoan(1L, 123, "ID1", "Loan 1", new BigDecimal("1000.00"), 15, new BigDecimal("100.00"), false, 456, LocalDate.now(), new BigDecimal("5.00"), LocalDateTime.now(), "Notes 1");
        when(personalLoanRepo.save(any(PersonalLoan.class))).thenReturn(loan);

        assertEquals(loan, personalLoanService.savePersonalLoan(loan));
    }

    @Test
    void testDeletePersonalLoan() {
        doNothing().when(personalLoanRepo).deleteById(1L);

        assertDoesNotThrow(() -> personalLoanService.deletePersonalLoan(1L));
        verify(personalLoanRepo, times(1)).deleteById(1L);
    }

    @Test
    void testUpdatePersonalLoan() {
        PersonalLoan existingLoan = new PersonalLoan(1L, 123, "ID1", "Loan 1", new BigDecimal("1000.00"), 15, new BigDecimal("100.00"), false, 456, LocalDate.now(), new BigDecimal("5.00"), LocalDateTime.now(), "Notes 1");
        PersonalLoan updatedLoan = new PersonalLoan(1L, 124, "ID2", "Loan 2", new BigDecimal("2000.00"), 20, new BigDecimal("200.00"), true, 457, LocalDate.now(), new BigDecimal("6.00"), LocalDateTime.now(), "Notes 2");

        when(personalLoanRepo.findById(1L)).thenReturn(Optional.of(existingLoan));
        when(personalLoanRepo.save(any(PersonalLoan.class))).thenReturn(updatedLoan);

        assertEquals(updatedLoan, personalLoanService.updatePersonalLoan(1L, updatedLoan));
    }

    @Test
    void testUpdatePersonalLoanNotFound() {
        PersonalLoan updatedLoan = new PersonalLoan(1L, 124, "ID2", "Loan 2", new BigDecimal("2000.00"), 20, new BigDecimal("200.00"), true, 457, LocalDate.now(), new BigDecimal("6.00"), LocalDateTime.now(), "Notes 2");

        when(personalLoanRepo.findById(1L)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> personalLoanService.updatePersonalLoan(1L, updatedLoan));
        assertEquals("PersonalLoan not found", thrown.getMessage());
    }
}
