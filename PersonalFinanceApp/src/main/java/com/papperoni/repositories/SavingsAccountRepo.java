package com.papperoni.repositories;

import com.papperoni.models.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccountRepo extends JpaRepository<SavingsAccount, Long> {
}

