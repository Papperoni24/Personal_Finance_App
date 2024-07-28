package com.papperoni.controllers;

import com.papperoni.models.ExpenseCategory;
import com.papperoni.services.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expensecategories")
public class ExpenseCategoryController {

    private final ExpenseCategoryService service;

    @Autowired
    public ExpenseCategoryController(ExpenseCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<ExpenseCategory> getAllExpenseCategories() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ExpenseCategory getExpenseCategoryById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ExpenseCategory createExpenseCategory(@RequestBody ExpenseCategory expenseCategory) {
        return service.save(expenseCategory);
    }

    @PutMapping("/{id}")
    public ExpenseCategory updateExpenseCategory(@PathVariable Long id, @RequestBody ExpenseCategory expenseCategory) {
        expenseCategory.setExpenseCategoryId(id);
        return service.save(expenseCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteExpenseCategory(@PathVariable Long id) {
        service.deleteById(id);
    }
}
