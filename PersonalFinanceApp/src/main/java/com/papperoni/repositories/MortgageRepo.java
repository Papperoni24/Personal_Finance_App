package com.papperoni.repositories;

import com.papperoni.models.Mortgage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgageRepo extends JpaRepository<Mortgage, Long> {
}
