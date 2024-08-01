package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "TransactionTypes")
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionTypeID")
    private Long transactionTypeId;

    @NotBlank
    @Size(max = 50)
    @Column(name = "TypeName", unique = true, nullable = false)
    private String typeName;

    @Size(max = 255)
    @Column(name = "Notes")
    private String notes;

    public TransactionType() {
    }

    public TransactionType(Long transactionTypeId, String typeName, String notes) {
        this.transactionTypeId = transactionTypeId;
        this.typeName = typeName;
        this.notes = notes;
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        TransactionType that = (TransactionType) o;
        return Objects.equals(transactionTypeId, that.transactionTypeId) &&
                Objects.equals(typeName, that.typeName) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionTypeId, typeName, notes);
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "transactionTypeId=" + transactionTypeId +
                ", typeName='" + typeName + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
