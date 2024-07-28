package com.papperoni.services;

import com.papperoni.models.TransactionDescription;

import java.util.List;
import java.util.Optional;

public interface TransactionDescriptionService {

    List<TransactionDescription> getAllTransactionDescriptions();

    Optional<TransactionDescription> getTransactionDescriptionById(Long id);

    TransactionDescription saveTransactionDescription(TransactionDescription transactionDescription);

    void deleteTransactionDescription(Long id);

    TransactionDescription updateTransactionDescription(Long id, TransactionDescription transactionDescriptionDetails);
}
