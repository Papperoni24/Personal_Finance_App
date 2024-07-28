package com.papperoni.services;

import com.papperoni.models.TransactionType;

import java.util.List;
import java.util.Optional;

public interface TransactionTypeService {

    List<TransactionType> getAllTransactionTypes();

    Optional<TransactionType> getTransactionTypeById(Long id);

    TransactionType saveTransactionType(TransactionType transactionType);

    void deleteTransactionType(Long id);

    TransactionType updateTransactionType(Long id, TransactionType transactionTypeDetails);
}

