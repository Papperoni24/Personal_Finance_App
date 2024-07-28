package com.papperoni.services;

import com.papperoni.models.PersonalLoan;

import java.util.List;
import java.util.Optional;

public interface PersonalLoanService {

    List<PersonalLoan> getAllPersonalLoans();

    Optional<PersonalLoan> getPersonalLoanById(Long id);

    PersonalLoan savePersonalLoan(PersonalLoan personalLoan);

    void deletePersonalLoan(Long id);

    PersonalLoan updatePersonalLoan(Long id, PersonalLoan personalLoanDetails);
}

