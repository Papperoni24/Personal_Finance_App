package com.papperoni.controllers;

import com.papperoni.models.TransDescMappingToBiz;
import com.papperoni.services.TransDescMappingToBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactionDescriptions")
public class TransDescMappingToBizController {

    private final TransDescMappingToBizService transDescMappingToBizService;

    @Autowired
    public TransDescMappingToBizController(TransDescMappingToBizService transDescMappingToBizService) {
        this.transDescMappingToBizService = transDescMappingToBizService;
    }

    @GetMapping
    public List<TransDescMappingToBiz> getAllTransactionDescriptions() {
        return transDescMappingToBizService.getAllTransactionDescriptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransDescMappingToBiz> getTransactionDescriptionById(@PathVariable Long id) {
        TransDescMappingToBiz transDescMappingToBiz = transDescMappingToBizService.getTransactionDescriptionById(id)
                .orElseThrow(() -> new RuntimeException("TransDescMappingToBiz not found"));
        return ResponseEntity.ok(transDescMappingToBiz);
    }

    @PostMapping
    public TransDescMappingToBiz createTransactionDescription(@RequestBody TransDescMappingToBiz transDescMappingToBiz) {
        return transDescMappingToBizService.saveTransactionDescription(transDescMappingToBiz);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransDescMappingToBiz> updateTransactionDescription(@PathVariable Long id, @RequestBody TransDescMappingToBiz transDescMappingToBizDetails) {
        TransDescMappingToBiz updatedTransDescMappingToBiz = transDescMappingToBizService.updateTransactionDescription(id, transDescMappingToBizDetails);
        return ResponseEntity.ok(updatedTransDescMappingToBiz);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionDescription(@PathVariable Long id) {
        transDescMappingToBizService.deleteTransactionDescription(id);
        return ResponseEntity.noContent().build();
    }
}
