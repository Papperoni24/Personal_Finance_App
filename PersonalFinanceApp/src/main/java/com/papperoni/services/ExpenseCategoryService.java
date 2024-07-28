package com.papperoni.services;

import com.papperoni.models.ExpenseCategory;

import java.util.List;

public interface ExpenseCategoryService {
    List<ExpenseCategory> findAll();
    ExpenseCategory findById(Long id);
    ExpenseCategory save(ExpenseCategory expenseCategory);
    void deleteById(Long id);
}

