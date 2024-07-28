package com.papperoni.repositories;

import com.papperoni.models.PersonalLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalLoanRepo extends JpaRepository<PersonalLoan, Long> {
}
