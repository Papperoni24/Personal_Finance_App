package com.papperoni.services.impl;

import com.papperoni.models.ExpenseCategory;
import com.papperoni.repositories.ExpenseCategoryRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ExpenseCategoryServiceImplTest {

    @Mock
    private ExpenseCategoryRepo expenseCategoryRepo;

    @InjectMocks
    private ExpenseCategoryServiceImpl expenseCategoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        ExpenseCategory category1 = new ExpenseCategory();
        ExpenseCategory category2 = new ExpenseCategory();
        List<ExpenseCategory> categories = Arrays.asList(category1, category2);

        when(expenseCategoryRepo.findAll()).thenReturn(categories);

        List<ExpenseCategory> result = expenseCategoryService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(expenseCategoryRepo, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setExpenseCategoryId(id);

        when(expenseCategoryRepo.findById(id)).thenReturn(Optional.of(expenseCategory));

        ExpenseCategory result = expenseCategoryService.findById(id);

        assertNotNull(result);
        assertEquals(id, result.getExpenseCategoryId());
        verify(expenseCategoryRepo, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        Long id = 2L;

        when(expenseCategoryRepo.findById(id)).thenReturn(Optional.empty());

        ExpenseCategory result = expenseCategoryService.findById(id);

        assertNull(result);
        verify(expenseCategoryRepo, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        when(expenseCategoryRepo.save(any(ExpenseCategory.class))).thenReturn(expenseCategory);

        ExpenseCategory result = expenseCategoryService.save(expenseCategory);

        assertNotNull(result);
        verify(expenseCategoryRepo, times(1)).save(expenseCategory);
    }

    @Test
    public void testDeleteById() {
        Long id = 3L;

        expenseCategoryService.deleteById(id);

        verify(expenseCategoryRepo, times(1)).deleteById(id);
    }
}
