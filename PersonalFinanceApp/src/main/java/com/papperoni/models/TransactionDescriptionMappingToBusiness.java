package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "TransactionDescriptionMappingToBusiness")
public class TransactionDescriptionMappingToBusiness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionDescriptionID")
    private Long transactionDescriptionId;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @Column(name = "Description", length = 255, unique = true, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "PlaceOfBusinessID")
    private int placeOfBusinessID;

    @Size(max = 255, message = "Notes cannot exceed 255 characters")
    @Column(name = "Notes", length = 255)
    private String notes;

    public TransactionDescriptionMappingToBusiness() {
    }

    public TransactionDescriptionMappingToBusiness(Long transactionDescriptionId, String description, int placeOfBusinessID, String notes) {
        this.transactionDescriptionId = transactionDescriptionId;
        this.description = description;
        this.placeOfBusinessID = placeOfBusinessID;
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

    public int getPlaceOfBusinessID() {
        return placeOfBusinessID;
    }

    public void setPlaceOfBusinessID(int placeOfBusinessID) {
        this.placeOfBusinessID = placeOfBusinessID;
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
        TransactionDescriptionMappingToBusiness that = (TransactionDescriptionMappingToBusiness) o;
        return Objects.equals(transactionDescriptionId, that.transactionDescriptionId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(placeOfBusinessID, that.placeOfBusinessID) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionDescriptionId, description, placeOfBusinessID, notes);
    }

    @Override
    public String toString() {
        return "TransactionDescriptionMappingToBusiness{" +
                "transactionDescriptionId=" + transactionDescriptionId +
                ", description='" + description + '\'' +
                ", placeOfBusinessID=" + placeOfBusinessID +
                ", notes='" + notes + '\'' +
                '}';
    }
}
