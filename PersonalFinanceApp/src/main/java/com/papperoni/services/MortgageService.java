package com.papperoni.services;

import com.papperoni.models.Mortgage;

import java.util.List;
import java.util.Optional;

public interface MortgageService {

    List<Mortgage> getAllMortgages();

    Optional<Mortgage> getMortgageById(Long id);

    Mortgage saveMortgage(Mortgage mortgage);

    void deleteMortgage(Long id);

    Mortgage updateMortgage(Long id, Mortgage mortgageDetails);
}

