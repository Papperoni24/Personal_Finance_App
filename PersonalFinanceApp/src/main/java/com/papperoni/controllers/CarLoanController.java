package com.papperoni.controllers;

import com.papperoni.models.CarLoan;
import com.papperoni.services.CarLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carloans")
public class CarLoanController {

    private final CarLoanService service;

    @Autowired
    public CarLoanController(CarLoanService service) {
        this.service = service;
    }

    @GetMapping
    public List<CarLoan> getAllCarLoans() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CarLoan getCarLoanById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public CarLoan createCarLoan(@RequestBody CarLoan carLoan) {
        return service.save(carLoan);
    }

    @PutMapping("/{id}")
    public CarLoan updateCarLoan(@PathVariable Long id, @RequestBody CarLoan carLoan) {
        carLoan.setCarLoanId(id);
        return service.save(carLoan);
    }

    @DeleteMapping("/{id}")
    public void deleteCarLoan(@PathVariable Long id) {
        service.deleteById(id);
    }
}
