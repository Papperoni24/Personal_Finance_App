package com.papperoni.services;

import com.papperoni.models.TransactionDescriptionMappingToBusiness;
import java.util.List;
import java.util.Optional;

public interface TransactionDescriptionMappingToBusinessService {
    List<TransactionDescriptionMappingToBusiness> getAllTransactionDescriptionMappings();
    Optional<TransactionDescriptionMappingToBusiness> getTransactionDescriptionMappingById(Long id);
    TransactionDescriptionMappingToBusiness saveTransactionDescriptionMapping(TransactionDescriptionMappingToBusiness transactionDescriptionMapping);
    void deleteTransactionDescriptionMapping(Long id);
    TransactionDescriptionMappingToBusiness updateTransactionDescriptionMapping(Long id, TransactionDescriptionMappingToBusiness transactionDescriptionMappingDetails);
}
