package com.papperoni.services;

import com.papperoni.models.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    List<Transaction> getAllTransactions();

    Optional<Transaction> getTransactionById(Long id);

    Transaction saveTransaction(Transaction transaction);

    void deleteTransaction(Long id);

    Transaction updateTransaction(Long id, Transaction transactionDetails);
}

