package com.papperoni.repositories;

import com.papperoni.models.StudentLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLoanRepo extends JpaRepository<StudentLoan, Long> {
}
