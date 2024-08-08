package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "PlaceOfBusiness")
public class PlaceOfBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlaceOfBusinessID")
    private Long placeOfBusinessId;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "Name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "DefaultPaymentID")
    private int defaultPaymentID;

    @Size(max = 255, message = "Notes cannot exceed 255 characters")
    @Column(name = "Notes", length = 255)
    private String notes;

    public PlaceOfBusiness() {
    }

    public PlaceOfBusiness(Long placeOfBusinessId, String name, int defaultPaymentID, String notes) {
        this.placeOfBusinessId = placeOfBusinessId;
        this.name = name;
        this.defaultPaymentID = defaultPaymentID;
        this.notes = notes;
    }

    public Long getPlaceOfBusinessId() {
        return placeOfBusinessId;
    }

    public void setPlaceOfBusinessId(Long placeOfBusinessId) {
        this.placeOfBusinessId = placeOfBusinessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefaultPaymentID() {
        return defaultPaymentID;
    }

    public void setDefaultPaymentID(int defaultPaymentID) {
        this.defaultPaymentID = defaultPaymentID;
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
        PlaceOfBusiness that = (PlaceOfBusiness) o;
        return Objects.equals(placeOfBusinessId, that.placeOfBusinessId) && Objects.equals(name, that.name) && Objects.equals(defaultPaymentID, that.defaultPaymentID) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeOfBusinessId, name, defaultPaymentID, notes);
    }

    @Override
    public String toString() {
        return "PlaceOfBusiness{" +
                "placeOfBusinessId=" + placeOfBusinessId +
                ", name='" + name + '\'' +
                ", defaultPaymentID=" + defaultPaymentID +
                ", notes='" + notes + '\'' +
                '}';
    }
}
