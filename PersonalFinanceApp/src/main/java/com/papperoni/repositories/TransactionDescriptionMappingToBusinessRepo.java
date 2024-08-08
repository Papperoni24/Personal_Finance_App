package com.papperoni.repositories;

import com.papperoni.models.TransactionDescriptionMappingToBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDescriptionMappingToBusinessRepo extends JpaRepository<TransactionDescriptionMappingToBusiness, Long> {
    // Custom query methods (if any) can be defined here
}


