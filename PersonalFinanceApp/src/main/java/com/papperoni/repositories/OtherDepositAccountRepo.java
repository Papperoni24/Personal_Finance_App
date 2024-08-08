package com.papperoni.repositories;

import com.papperoni.models.OtherDepositAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherDepositAccountRepo extends JpaRepository<OtherDepositAccount, Long> {
}

