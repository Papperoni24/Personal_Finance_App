package com.papperoni.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ExpenseCategory")
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseCategoryId;

    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "placeOfBusinessId")
    private PlaceOfBusiness placeOfBusiness;

    private String notes;
}
