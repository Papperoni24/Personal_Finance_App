package com.papperoni.services.impl;

import com.papperoni.models.Transaction;
import com.papperoni.repositories.TransactionRepo;
import com.papperoni.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepo transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        transaction.setAmount(transactionDetails.getAmount());
        transaction.setDescription(transactionDetails.getDescription());
        transaction.setAccountId(transactionDetails.getAccountId());
        transaction.setPlaceOfBusiness(transactionDetails.getPlaceOfBusiness());
        transaction.setTransactionType(transactionDetails.getTransactionType());
        transaction.setAssociatedAccountId(transactionDetails.getAssociatedAccountId());
        transaction.setAssociatedAccountType(transactionDetails.getAssociatedAccountType());
        transaction.setTransactionDate(transactionDetails.getTransactionDate());
        transaction.setIsRecurring(transactionDetails.getIsRecurring());

        return transactionRepository.save(transaction);
    }
}
