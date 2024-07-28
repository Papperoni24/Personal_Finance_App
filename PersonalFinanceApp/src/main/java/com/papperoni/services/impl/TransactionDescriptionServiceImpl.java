package com.papperoni.services.impl;

import com.papperoni.models.TransactionDescription;
import com.papperoni.repositories.TransactionDescriptionRepo;
import com.papperoni.services.TransactionDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionDescriptionServiceImpl implements TransactionDescriptionService {

    private final TransactionDescriptionRepo transactionDescriptionRepository;

    @Autowired
    public TransactionDescriptionServiceImpl(TransactionDescriptionRepo transactionDescriptionRepository) {
        this.transactionDescriptionRepository = transactionDescriptionRepository;
    }

    @Override
    public List<TransactionDescription> getAllTransactionDescriptions() {
        return transactionDescriptionRepository.findAll();
    }

    @Override
    public Optional<TransactionDescription> getTransactionDescriptionById(Long id) {
        return transactionDescriptionRepository.findById(id);
    }

    @Override
    public TransactionDescription saveTransactionDescription(TransactionDescription transactionDescription) {
        return transactionDescriptionRepository.save(transactionDescription);
    }

    @Override
    public void deleteTransactionDescription(Long id) {
        transactionDescriptionRepository.deleteById(id);
    }

    @Override
    public TransactionDescription updateTransactionDescription(Long id, TransactionDescription transactionDescriptionDetails) {
        TransactionDescription transactionDescription = transactionDescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionDescription not found"));

        transactionDescription.setDescription(transactionDescriptionDetails.getDescription());
        transactionDescription.setPlaceOfBusiness(transactionDescriptionDetails.getPlaceOfBusiness());
        transactionDescription.setNotes(transactionDescriptionDetails.getNotes());

        return transactionDescriptionRepository.save(transactionDescription);
    }
}
