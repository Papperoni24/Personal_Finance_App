package com.papperoni.services.impl;

import com.papperoni.models.TransDescMappingToBiz;
import com.papperoni.repositories.TransactionDescriptionRepo;
import com.papperoni.services.TransDescMappingToBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransDescMappingToBizServiceImpl implements TransDescMappingToBizService {

    private final TransactionDescriptionRepo transactionDescriptionRepository;

    @Autowired
    public TransDescMappingToBizServiceImpl(TransactionDescriptionRepo transactionDescriptionRepository) {
        this.transactionDescriptionRepository = transactionDescriptionRepository;
    }

    @Override
    public List<TransDescMappingToBiz> getAllTransactionDescriptions() {
        return transactionDescriptionRepository.findAll();
    }

    @Override
    public Optional<TransDescMappingToBiz> getTransactionDescriptionById(Long id) {
        return transactionDescriptionRepository.findById(id);
    }

    @Override
    public TransDescMappingToBiz saveTransactionDescription(TransDescMappingToBiz transDescMappingToBiz) {
        return transactionDescriptionRepository.save(transDescMappingToBiz);
    }

    @Override
    public void deleteTransactionDescription(Long id) {
        transactionDescriptionRepository.deleteById(id);
    }

    @Override
    public TransDescMappingToBiz updateTransactionDescription(Long id, TransDescMappingToBiz transDescMappingToBizDetails) {
        TransDescMappingToBiz transDescMappingToBiz = transactionDescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransDescMappingToBiz not found"));

        transDescMappingToBiz.setDescription(transDescMappingToBizDetails.getDescription());
        transDescMappingToBiz.setPlaceOfBusiness(transDescMappingToBizDetails.getPlaceOfBusiness());
        transDescMappingToBiz.setNotes(transDescMappingToBizDetails.getNotes());

        return transactionDescriptionRepository.save(transDescMappingToBiz);
    }
}
