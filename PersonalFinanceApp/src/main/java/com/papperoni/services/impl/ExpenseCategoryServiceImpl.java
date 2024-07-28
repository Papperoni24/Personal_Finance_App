package com.papperoni.services.impl;

import com.papperoni.models.ExpenseCategory;
import com.papperoni.repositories.ExpenseCategoryRepo;
import com.papperoni.services.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {

    private final ExpenseCategoryRepo repository;

    @Autowired
    public ExpenseCategoryServiceImpl(ExpenseCategoryRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<ExpenseCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public ExpenseCategory findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ExpenseCategory save(ExpenseCategory expenseCategory) {
        return repository.save(expenseCategory);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

