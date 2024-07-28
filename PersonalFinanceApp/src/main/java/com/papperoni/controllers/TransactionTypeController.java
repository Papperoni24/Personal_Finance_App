package com.papperoni.controllers;

import com.papperoni.models.TransactionType;
import com.papperoni.services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactionTypes")
public class TransactionTypeController {

    private final TransactionTypeService transactionTypeService;

    @Autowired
    public TransactionTypeController(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }

    @GetMapping
    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeService.getAllTransactionTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionType> getTransactionTypeById(@PathVariable Long id) {
        TransactionType transactionType = transactionTypeService.getTransactionTypeById(id)
                .orElseThrow(() -> new RuntimeException("TransactionType not found"));
        return ResponseEntity.ok(transactionType);
    }

    @PostMapping
    public TransactionType createTransactionType(@RequestBody TransactionType transactionType) {
        return transactionTypeService.saveTransactionType(transactionType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionType> updateTransactionType(@PathVariable Long id, @RequestBody TransactionType transactionTypeDetails) {
        TransactionType updatedTransactionType = transactionTypeService.updateTransactionType(id, transactionTypeDetails);
        return ResponseEntity.ok(updatedTransactionType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionType(@PathVariable Long id) {
        transactionTypeService.deleteTransactionType(id);
        return ResponseEntity.noContent().build();
    }
}

