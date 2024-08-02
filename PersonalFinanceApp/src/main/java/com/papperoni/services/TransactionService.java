package com.papperoni.services;

import com.papperoni.models.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    List<Transaction> getAllTransactions();

    Optional<Transaction> getTransactionById(int id);

    Transaction saveTransaction(Transaction transaction);

    void deleteTransaction(int id);

    Transaction updateTransaction(int id, Transaction transactionDetails);
}

