package com.papperoni.services.impl;

import com.papperoni.models.Mortgage;
import com.papperoni.repositories.MortgageRepo;
import com.papperoni.services.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MortgageServiceImpl implements MortgageService {

    private final MortgageRepo mortgageRepository;

    @Autowired
    public MortgageServiceImpl(MortgageRepo mortgageRepository) {
        this.mortgageRepository = mortgageRepository;
    }

    @Override
    public List<Mortgage> getAllMortgages() {
        return mortgageRepository.findAll();
    }

    @Override
    public Optional<Mortgage> getMortgageById(Long id) {
        return mortgageRepository.findById(id);
    }

    @Override
    public Mortgage saveMortgage(Mortgage mortgage) {
        return mortgageRepository.save(mortgage);
    }

    @Override
    public void deleteMortgage(Long id) {
        mortgageRepository.deleteById(id);
    }

    @Override
    public Mortgage updateMortgage(Long id, Mortgage mortgageDetails) {
        Mortgage mortgage = mortgageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mortgage not found"));

        mortgage.setOwnerID(mortgageDetails.getOwnerID());
        mortgage.setAccountIdentifier(mortgageDetails.getAccountIdentifier());
        mortgage.setAccountName(mortgageDetails.getAccountName());
        mortgage.setBalance(mortgageDetails.getBalance());
        mortgage.setPaymentDate(mortgageDetails.getPaymentDate());
        mortgage.setMinMonthlyPayment(mortgageDetails.getMinMonthlyPayment());
        mortgage.setAutoPay(mortgageDetails.getAutoPay());
        mortgage.setDefaultPaymentID(mortgageDetails.getDefaultPaymentID());
        mortgage.setUpdated(mortgageDetails.getUpdated());
        mortgage.setApr(mortgageDetails.getApr());
        mortgage.setCreatedAt(mortgageDetails.getCreatedAt());
        mortgage.setNotes(mortgageDetails.getNotes());

        return mortgageRepository.save(mortgage);
    }
}

