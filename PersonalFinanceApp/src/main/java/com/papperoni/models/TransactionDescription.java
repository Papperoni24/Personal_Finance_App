package com.papperoni.models;

import jakarta.persistence.*;

import java.util.Objects;

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

    public TransactionDescription() {
    }

    public TransactionDescription(Long transactionDescriptionId, String description, PlaceOfBusiness placeOfBusiness, String notes) {
        this.transactionDescriptionId = transactionDescriptionId;
        this.description = description;
        this.placeOfBusiness = placeOfBusiness;
        this.notes = notes;
    }

    public Long getTransactionDescriptionId() {
        return transactionDescriptionId;
    }

    public void setTransactionDescriptionId(Long transactionDescriptionId) {
        this.transactionDescriptionId = transactionDescriptionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PlaceOfBusiness getPlaceOfBusiness() {
        return placeOfBusiness;
    }

    public void setPlaceOfBusiness(PlaceOfBusiness placeOfBusiness) {
        this.placeOfBusiness = placeOfBusiness;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDescription that = (TransactionDescription) o;
        return Objects.equals(transactionDescriptionId, that.transactionDescriptionId) && Objects.equals(description, that.description) && Objects.equals(placeOfBusiness, that.placeOfBusiness) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionDescriptionId, description, placeOfBusiness, notes);
    }

    @Override
    public String toString() {
        return "TransactionDescription{" +
                "transactionDescriptionId=" + transactionDescriptionId +
                ", description='" + description + '\'' +
                ", placeOfBusiness=" + placeOfBusiness +
                ", notes='" + notes + '\'' +
                '}';
    }
}