package com.papperoni.models;

import jakarta.persistence.*;

@Entity
@Table(name = "KeyTransactionDescription")
public class TransactionDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionDescriptionId;

    private String description;

    @ManyToOne
    @JoinColumn(name = "placeOfBusinessId")
    private PlaceOfBusiness placeOfBusiness;

    private String notes;
}