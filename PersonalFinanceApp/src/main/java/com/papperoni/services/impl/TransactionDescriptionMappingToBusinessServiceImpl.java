package com.papperoni.services.impl;

import com.papperoni.models.TransactionDescriptionMappingToBusiness;
import com.papperoni.repositories.TransactionDescriptionMappingToBusinessRepo;
import com.papperoni.services.TransactionDescriptionMappingToBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionDescriptionMappingToBusinessServiceImpl implements TransactionDescriptionMappingToBusinessService {

    private final TransactionDescriptionMappingToBusinessRepo transactionDescriptionMappingToBusinessRepo;

    @Autowired
    public TransactionDescriptionMappingToBusinessServiceImpl(TransactionDescriptionMappingToBusinessRepo transactionDescriptionMappingToBusinessRepo) {
        this.transactionDescriptionMappingToBusinessRepo = transactionDescriptionMappingToBusinessRepo;
    }

    @Override
    public List<TransactionDescriptionMappingToBusiness> getAllTransactionDescriptionMappings() {
        return transactionDescriptionMappingToBusinessRepo.findAll();
    }

    @Override
    public Optional<TransactionDescriptionMappingToBusiness> getTransactionDescriptionMappingById(Long id) {
        return transactionDescriptionMappingToBusinessRepo.findById(id);
    }

    @Override
    public TransactionDescriptionMappingToBusiness saveTransactionDescriptionMapping(TransactionDescriptionMappingToBusiness transactionDescriptionMapping) {
        return transactionDescriptionMappingToBusinessRepo.save(transactionDescriptionMapping);
    }

    @Override
    public void deleteTransactionDescriptionMapping(Long id) {
        transactionDescriptionMappingToBusinessRepo.deleteById(id);
    }

    @Override
    public TransactionDescriptionMappingToBusiness updateTransactionDescriptionMapping(Long id, TransactionDescriptionMappingToBusiness transactionDescriptionMappingDetails) {
        TransactionDescriptionMappingToBusiness transactionDescriptionMapping = transactionDescriptionMappingToBusinessRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionDescriptionMappingToBusiness not found"));

        transactionDescriptionMapping.setDescription(transactionDescriptionMappingDetails.getDescription());
        transactionDescriptionMapping.setPlaceOfBusinessID(transactionDescriptionMappingDetails.getPlaceOfBusinessID());
        transactionDescriptionMapping.setNotes(transactionDescriptionMappingDetails.getNotes());

        return transactionDescriptionMappingToBusinessRepo.save(transactionDescriptionMapping);
    }
}
