package com.papperoni.repositories;

import com.papperoni.models.OtherDepositAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialAccountRepo extends JpaRepository<OtherDepositAccount, Long> {
}

