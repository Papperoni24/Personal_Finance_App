package com.papperoni.controllers;

import com.papperoni.models.TransactionDescriptionMappingToBusiness;
import com.papperoni.services.TransactionDescriptionMappingToBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transaction-descriptions")
public class TransactionDescriptionMappingToBusinessController {

    private final TransactionDescriptionMappingToBusinessService service;

    @Autowired
    public TransactionDescriptionMappingToBusinessController(TransactionDescriptionMappingToBusinessService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TransactionDescriptionMappingToBusiness>> getAllTransactionDescriptions() {
        List<TransactionDescriptionMappingToBusiness> descriptions = service.getAllTransactionDescriptionMappings();
        return new ResponseEntity<>(descriptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDescriptionMappingToBusiness> getTransactionDescriptionById(@PathVariable Long id) {
        Optional<TransactionDescriptionMappingToBusiness> description = service.getTransactionDescriptionMappingById(id);
        return description.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TransactionDescriptionMappingToBusiness> createTransactionDescription(@RequestBody TransactionDescriptionMappingToBusiness description) {
        TransactionDescriptionMappingToBusiness newDescription = service.saveTransactionDescriptionMapping(description);
        return new ResponseEntity<>(newDescription, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDescriptionMappingToBusiness> updateTransactionDescription(@PathVariable Long id, @RequestBody TransactionDescriptionMappingToBusiness descriptionDetails) {
        TransactionDescriptionMappingToBusiness updatedDescription = service.updateTransactionDescriptionMapping(id, descriptionDetails);
        return new ResponseEntity<>(updatedDescription, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionDescription(@PathVariable Long id) {
        service.deleteTransactionDescriptionMapping(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

