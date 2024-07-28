package com.papperoni.services.impl;

import com.papperoni.models.CarLoan;
import com.papperoni.repositories.CarLoanRepo;
import com.papperoni.services.CarLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarLoanServiceImpl implements CarLoanService {

    private final CarLoanRepo repository;

    @Autowired
    public CarLoanServiceImpl(CarLoanRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<CarLoan> findAll() {
        return repository.findAll();
    }

    @Override
    public CarLoan findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CarLoan save(CarLoan carLoan) {
        return repository.save(carLoan);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

