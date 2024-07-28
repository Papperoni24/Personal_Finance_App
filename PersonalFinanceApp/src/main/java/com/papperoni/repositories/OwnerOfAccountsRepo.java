package com.papperoni.repositories;

import com.papperoni.models.OwnerOfAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerOfAccountsRepo extends JpaRepository<OwnerOfAccount, Long> {
    // Custom query methods can be added here if needed
}
