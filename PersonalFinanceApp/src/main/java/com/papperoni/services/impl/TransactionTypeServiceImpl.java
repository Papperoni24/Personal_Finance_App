package com.papperoni.services.impl;

import com.papperoni.models.TransactionType;
import com.papperoni.repositories.TransactionTypeRepo;
import com.papperoni.services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {

    private final TransactionTypeRepo transactionTypeRepository;

    @Autowired
    public TransactionTypeServiceImpl(TransactionTypeRepo transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    @Override
    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeRepository.findAll();
    }

    @Override
    public Optional<TransactionType> getTransactionTypeById(Long id) {
        return transactionTypeRepository.findById(id);
    }

    @Override
    public TransactionType saveTransactionType(TransactionType transactionType) {
        return transactionTypeRepository.save(transactionType);
    }

    @Override
    public void deleteTransactionType(Long id) {
        transactionTypeRepository.deleteById(id);
    }

    @Override
    public TransactionType updateTransactionType(Long id, TransactionType transactionTypeDetails) {
        TransactionType transactionType = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionType not found"));

        transactionType.setTypeName(transactionTypeDetails.getTypeName());
        transactionType.setNotes(transactionTypeDetails.getNotes());

        return transactionTypeRepository.save(transactionType);
    }
}
