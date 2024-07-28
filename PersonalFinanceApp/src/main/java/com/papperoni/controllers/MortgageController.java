package com.papperoni.controllers;

import com.papperoni.models.Mortgage;
import com.papperoni.services.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mortgages")
public class MortgageController {

    private final MortgageService mortgageService;

    @Autowired
    public MortgageController(MortgageService mortgageService) {
        this.mortgageService = mortgageService;
    }

    @GetMapping
    public List<Mortgage> getAllMortgages() {
        return mortgageService.getAllMortgages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mortgage> getMortgageById(@PathVariable Long id) {
        Mortgage mortgage = mortgageService.getMortgageById(id)
                .orElseThrow(() -> new RuntimeException("Mortgage not found"));
        return ResponseEntity.ok(mortgage);
    }

    @PostMapping
    public Mortgage createMortgage(@RequestBody Mortgage mortgage) {
        return mortgageService.saveMortgage(mortgage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mortgage> updateMortgage(@PathVariable Long id, @RequestBody Mortgage mortgageDetails) {
        Mortgage updatedMortgage = mortgageService.updateMortgage(id, mortgageDetails);
        return ResponseEntity.ok(updatedMortgage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMortgage(@PathVariable Long id) {
        mortgageService.deleteMortgage(id);
        return ResponseEntity.noContent().build();
    }
}

