package com.papperoni.repositories;

import com.papperoni.models.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepo extends JpaRepository<CheckingAccount, Long> {
    // Custom query methods can be added here if needed
}

