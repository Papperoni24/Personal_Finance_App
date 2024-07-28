package com.papperoni.controllers;

import com.papperoni.models.PersonalLoan;
import com.papperoni.services.PersonalLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-loans")
public class PersonalLoanController {

    private final PersonalLoanService personalLoanService;

    @Autowired
    public PersonalLoanController(PersonalLoanService personalLoanService) {
        this.personalLoanService = personalLoanService;
    }

    @GetMapping
    public List<PersonalLoan> getAllPersonalLoans() {
        return personalLoanService.getAllPersonalLoans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalLoan> getPersonalLoanById(@PathVariable Long id) {
        PersonalLoan personalLoan = personalLoanService.getPersonalLoanById(id)
                .orElseThrow(() -> new RuntimeException("PersonalLoan not found"));
        return ResponseEntity.ok(personalLoan);
    }

    @PostMapping
    public PersonalLoan createPersonalLoan(@RequestBody PersonalLoan personalLoan) {
        return personalLoanService.savePersonalLoan(personalLoan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalLoan> updatePersonalLoan(@PathVariable Long id, @RequestBody PersonalLoan personalLoanDetails) {
        PersonalLoan updatedPersonalLoan = personalLoanService.updatePersonalLoan(id, personalLoanDetails);
        return ResponseEntity.ok(updatedPersonalLoan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalLoan(@PathVariable Long id) {
        personalLoanService.deletePersonalLoan(id);
        return ResponseEntity.noContent().build();
    }
}

