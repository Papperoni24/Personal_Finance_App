package com.papperoni.repositories;

import com.papperoni.models.SocialAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialAccountRepo extends JpaRepository<SocialAccount, Long> {
}

