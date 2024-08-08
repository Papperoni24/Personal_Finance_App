package com.papperoni.services.impl;

import com.papperoni.models.StudentLoan;
import com.papperoni.repositories.StudentLoanRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class StudentLoanServiceImplTest {

    @Mock
    private StudentLoanRepo studentLoanRepo;

    @InjectMocks
    private StudentLoanServiceImpl studentLoanService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudentLoans() {
        StudentLoan loan = new StudentLoan(1L, 123, "ID123", new BigDecimal("5000.00"),
                "Loan A", 15, new BigDecimal("100.00"),
                true, 1, LocalDate.now(),
                new BigDecimal("5.50"), LocalDateTime.now(),
                "Notes");
        when(studentLoanRepo.findAll()).thenReturn(Collections.singletonList(loan));

        assertEquals(1, studentLoanService.getAllStudentLoans().size());
        verify(studentLoanRepo, times(1)).findAll();
    }

    @Test
    public void testGetStudentLoanById() {
        StudentLoan loan = new StudentLoan(1L, 123, "ID123", new BigDecimal("5000.00"),
                "Loan A", 15, new BigDecimal("100.00"),
                true, 1, LocalDate.now(),
                new BigDecimal("5.50"), LocalDateTime.now(),
                "Notes");
        when(studentLoanRepo.findById(anyLong())).thenReturn(Optional.of(loan));

        Optional<StudentLoan> result = studentLoanService.getStudentLoanById(1L);
        assertTrue(result.isPresent());
        assertEquals(loan, result.get());
        verify(studentLoanRepo, times(1)).findById(anyLong());
    }

    @Test
    public void testSaveStudentLoan() {
        StudentLoan loan = new StudentLoan(1L, 123, "ID123", new BigDecimal("5000.00"),
                "Loan A", 15, new BigDecimal("100.00"),
                true, 1, LocalDate.now(),
                new BigDecimal("5.50"), LocalDateTime.now(),
                "Notes");
        when(studentLoanRepo.save(any(StudentLoan.class))).thenReturn(loan);

        StudentLoan result = studentLoanService.saveStudentLoan(loan);
        assertEquals(loan, result);
        verify(studentLoanRepo, times(1)).save(any(StudentLoan.class));
    }

    @Test
    public void testDeleteStudentLoan() {
        doNothing().when(studentLoanRepo).deleteById(anyLong());

        studentLoanService.deleteStudentLoan(1L);
        verify(studentLoanRepo, times(1)).deleteById(anyLong());
    }

    @Test
    public void testUpdateStudentLoan() {
        StudentLoan existingLoan = new StudentLoan(1L, 123, "ID123", new BigDecimal("5000.00"),
                "Loan A", 15, new BigDecimal("100.00"),
                true, 1, LocalDate.now(),
                new BigDecimal("5.50"), LocalDateTime.now(),
                "Notes");

        StudentLoan updatedLoan = new StudentLoan(1L, 123, "ID12345", new BigDecimal("6000.00"),
                "Loan B", 20, new BigDecimal("150.00"),
                false, 2, LocalDate.now().plusDays(1),
                new BigDecimal("6.00"), LocalDateTime.now().plusDays(1),
                "Updated Notes");

        when(studentLoanRepo.findById(anyLong())).thenReturn(Optional.of(existingLoan));
        when(studentLoanRepo.save(any(StudentLoan.class))).thenReturn(updatedLoan);

        StudentLoan result = studentLoanService.updateStudentLoan(1L, updatedLoan);
        assertEquals(updatedLoan, result);
        verify(studentLoanRepo, times(1)).findById(anyLong());
        verify(studentLoanRepo, times(1)).save(any(StudentLoan.class));
    }
}

