package com.papperoni.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TransactionTypes")
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionTypeId;

    private String typeName;
    private String notes;
}