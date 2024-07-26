package com.papperoni.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PlaceOfBusiness")
public class PlaceOfBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeOfBusinessId;

    private String name;
    private String notes;
}