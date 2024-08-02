package com.papperoni.repositories;

import com.papperoni.models.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType, Integer> {
    // Custom query methods can be added here if needed
}

