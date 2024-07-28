package com.papperoni.repositories;

import com.papperoni.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepo extends JpaRepository<TransactionType, Long> {
}

