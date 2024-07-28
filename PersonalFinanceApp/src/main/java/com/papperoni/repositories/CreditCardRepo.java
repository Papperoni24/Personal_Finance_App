package com.papperoni.repositories;

import com.papperoni.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepo extends JpaRepository<CreditCard, Long> {
    // Custom query methods can be added here if needed
}

