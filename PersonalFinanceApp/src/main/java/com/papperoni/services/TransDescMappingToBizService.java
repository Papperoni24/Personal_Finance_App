package com.papperoni.services;

import com.papperoni.models.TransDescMappingToBiz;

import java.util.List;
import java.util.Optional;

public interface TransDescMappingToBizService {

    List<TransDescMappingToBiz> getAllTransactionDescriptions();

    Optional<TransDescMappingToBiz> getTransactionDescriptionById(Long id);

    TransDescMappingToBiz saveTransactionDescription(TransDescMappingToBiz transDescMappingToBiz);

    void deleteTransactionDescription(Long id);

    TransDescMappingToBiz updateTransactionDescription(Long id, TransDescMappingToBiz transDescMappingToBizDetails);
}
