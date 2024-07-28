package com.papperoni.repositories;

import com.papperoni.models.CarLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarLoanRepo extends JpaRepository<CarLoan, Long> {
    // Custom query methods can be added here if needed
}

