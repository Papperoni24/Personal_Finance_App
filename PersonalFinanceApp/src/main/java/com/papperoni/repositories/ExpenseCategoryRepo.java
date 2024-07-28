package com.papperoni.repositories;

import com.papperoni.models.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCategoryRepo extends JpaRepository<ExpenseCategory, Long> {
    // Custom query methods can be added here if needed
}

