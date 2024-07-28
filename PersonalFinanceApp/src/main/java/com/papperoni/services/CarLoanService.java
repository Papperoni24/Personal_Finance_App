package com.papperoni.services;

import com.papperoni.models.CarLoan;

import java.util.List;

public interface CarLoanService {
    List<CarLoan> findAll();
    CarLoan findById(Long id);
    CarLoan save(CarLoan carLoan);
    void deleteById(Long id);
}
