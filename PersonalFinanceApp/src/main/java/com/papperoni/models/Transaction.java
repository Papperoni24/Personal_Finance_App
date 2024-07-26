package com.papperoni.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    private OwnerOfAccount owner;

    private Long depositId;
    private Long creditCardId;
    private Long otherCreditAccountId;
    private Long studentLoanId;
    private Long personalLoanId;
    private Long carLoanId;
    private Long mortgageId;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "transactionTypeId")
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "transactionDescriptionId")
    private TransactionDescription transactionDescription;

    @ManyToOne
    @JoinColumn(name = "expenseCategoryId")
    private ExpenseCategory expenseCategory;

    private Long associatedAccountId;
    private String associatedAccountType;
    private LocalDateTime transactionDate;
    private String notes;
}
