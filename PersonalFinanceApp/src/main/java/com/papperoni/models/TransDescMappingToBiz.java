package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "TransDescMappingToBiz")
public class TransDescMappingToBiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionDescriptionID")
    private Long transactionDescriptionId;

    @NotBlank
    @Size(max = 255)
    @Column(name = "Description", nullable = false, unique = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "PlaceOfBusinessID")
    private PlaceOfBusiness placeOfBusiness;

    @Size(max = 255)
    @Column(name = "Notes")
    private String notes;

    public TransDescMappingToBiz() {
    }

    public TransDescMappingToBiz(Long transactionDescriptionId, String description, PlaceOfBusiness placeOfBusiness, String notes) {
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
        TransDescMappingToBiz that = (TransDescMappingToBiz) o;
        return Objects.equals(transactionDescriptionId, that.transactionDescriptionId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(placeOfBusiness, that.placeOfBusiness) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionDescriptionId, description, placeOfBusiness, notes);
    }

    @Override
    public String toString() {
        return "TransDescMappingToBiz{" +
                "transactionDescriptionId=" + transactionDescriptionId +
                ", description='" + description + '\'' +
                ", placeOfBusiness=" + placeOfBusiness +
                ", notes='" + notes + '\'' +
                '}';
    }
}
