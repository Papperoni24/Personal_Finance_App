package com.papperoni.services.impl;

import com.papperoni.models.PersonalLoan;
import com.papperoni.repositories.PersonalLoanRepo;
import com.papperoni.services.PersonalLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalLoanServiceImpl implements PersonalLoanService {

    private final PersonalLoanRepo personalLoanRepository;

    @Autowired
    public PersonalLoanServiceImpl(PersonalLoanRepo personalLoanRepository) {
        this.personalLoanRepository = personalLoanRepository;
    }

    @Override
    public List<PersonalLoan> getAllPersonalLoans() {
        return personalLoanRepository.findAll();
    }

    @Override
    public Optional<PersonalLoan> getPersonalLoanById(Long id) {
        return personalLoanRepository.findById(id);
    }

    @Override
    public PersonalLoan savePersonalLoan(PersonalLoan personalLoan) {
        return personalLoanRepository.save(personalLoan);
    }

    @Override
    public void deletePersonalLoan(Long id) {
        personalLoanRepository.deleteById(id);
    }

    @Override
    public PersonalLoan updatePersonalLoan(Long id, PersonalLoan personalLoanDetails) {
        PersonalLoan personalLoan = personalLoanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PersonalLoan not found"));

        personalLoan.setOwner(personalLoanDetails.getOwnerID());
        personalLoan.setAccountIdentifier(personalLoanDetails.getAccountIdentifier());
        personalLoan.setAccountName(personalLoanDetails.getAccountName());
        personalLoan.setBalance(personalLoanDetails.getBalance());
        personalLoan.setPaymentDate(personalLoanDetails.getPaymentDate());
        personalLoan.setMinMonthlyPayment(personalLoanDetails.getMinMonthlyPayment());
        personalLoan.setAutoPay(personalLoanDetails.getAutoPay());
        personalLoan.setDefaultPaymentID(personalLoanDetails.getDefaultPaymentID());
        personalLoan.setUpdated(personalLoanDetails.getUpdated());
        personalLoan.setApr(personalLoanDetails.getApr());
        personalLoan.setCreatedAt(personalLoanDetails.getCreatedAt());
        personalLoan.setNotes(personalLoanDetails.getNotes());

        return personalLoanRepository.save(personalLoan);
    }
}

