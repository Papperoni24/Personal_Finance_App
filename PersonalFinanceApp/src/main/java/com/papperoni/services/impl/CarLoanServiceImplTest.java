package com.papperoni.services.impl;

import com.papperoni.models.CarLoan;
import com.papperoni.repositories.CarLoanRepo;
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

public class CarLoanServiceImplTest {

    @Mock
    private CarLoanRepo carLoanRepo;

    @InjectMocks
    private CarLoanServiceImpl carLoanService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        CarLoan loan1 = new CarLoan();
        CarLoan loan2 = new CarLoan();
        List<CarLoan> carLoans = Arrays.asList(loan1, loan2);

        when(carLoanRepo.findAll()).thenReturn(carLoans);

        List<CarLoan> result = carLoanService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(carLoanRepo, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        CarLoan carLoan = new CarLoan();
        carLoan.setCarLoanId(id);

        when(carLoanRepo.findById(id)).thenReturn(Optional.of(carLoan));

        CarLoan result = carLoanService.findById(id);

        assertNotNull(result);
        assertEquals(id, result.getCarLoanId());
        verify(carLoanRepo, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        Long id = 2L;

        when(carLoanRepo.findById(id)).thenReturn(Optional.empty());

        CarLoan result = carLoanService.findById(id);

        assertNull(result);
        verify(carLoanRepo, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        CarLoan carLoan = new CarLoan();
        when(carLoanRepo.save(any(CarLoan.class))).thenReturn(carLoan);

        CarLoan result = carLoanService.save(carLoan);

        assertNotNull(result);
        verify(carLoanRepo, times(1)).save(carLoan);
    }

    @Test
    public void testDeleteById() {
        Long id = 3L;

        carLoanService.deleteById(id);

        verify(carLoanRepo, times(1)).deleteById(id);
    }
}
