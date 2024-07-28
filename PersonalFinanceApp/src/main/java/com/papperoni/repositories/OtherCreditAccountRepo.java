package com.papperoni.repositories;

import com.papperoni.models.OtherCreditAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherCreditAccountRepo extends JpaRepository<OtherCreditAccount, Long> {
}

