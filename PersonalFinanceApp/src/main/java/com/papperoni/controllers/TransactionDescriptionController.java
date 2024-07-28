package com.papperoni.controllers;

import com.papperoni.models.TransactionDescription;
import com.papperoni.services.TransactionDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactionDescriptions")
public class TransactionDescriptionController {

    private final TransactionDescriptionService transactionDescriptionService;

    @Autowired
    public TransactionDescriptionController(TransactionDescriptionService transactionDescriptionService) {
        this.transactionDescriptionService = transactionDescriptionService;
    }

    @GetMapping
    public List<TransactionDescription> getAllTransactionDescriptions() {
        return transactionDescriptionService.getAllTransactionDescriptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDescription> getTransactionDescriptionById(@PathVariable Long id) {
        TransactionDescription transactionDescription = transactionDescriptionService.getTransactionDescriptionById(id)
                .orElseThrow(() -> new RuntimeException("TransactionDescription not found"));
        return ResponseEntity.ok(transactionDescription);
    }

    @PostMapping
    public TransactionDescription createTransactionDescription(@RequestBody TransactionDescription transactionDescription) {
        return transactionDescriptionService.saveTransactionDescription(transactionDescription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDescription> updateTransactionDescription(@PathVariable Long id, @RequestBody TransactionDescription transactionDescriptionDetails) {
        TransactionDescription updatedTransactionDescription = transactionDescriptionService.updateTransactionDescription(id, transactionDescriptionDetails);
        return ResponseEntity.ok(updatedTransactionDescription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionDescription(@PathVariable Long id) {
        transactionDescriptionService.deleteTransactionDescription(id);
        return ResponseEntity.noContent().build();
    }
}
