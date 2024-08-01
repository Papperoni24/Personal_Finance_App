package com.papperoni.repositories;

import com.papperoni.models.TransDescMappingToBiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDescriptionRepo extends JpaRepository<TransDescMappingToBiz, Long> {
}

