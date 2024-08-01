package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

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

    @Column(name = "DefaultPayment", length = 100)
    private String defaultPayment;

    @Column(name = "Notes", length = 255)
    private String notes;

    public PlaceOfBusiness() {
    }

    public PlaceOfBusiness(Long placeOfBusinessId, String name, String defaultPayment, String notes) {
        this.placeOfBusinessId = placeOfBusinessId;
        this.name = name;
        this.defaultPayment = defaultPayment;
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

    public String getDefaultPayment() {
        return defaultPayment;
    }

    public void setDefaultPayment(String defaultPayment) {
        this.defaultPayment = defaultPayment;
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
        return Objects.equals(placeOfBusinessId, that.placeOfBusinessId) && Objects.equals(name, that.name) && Objects.equals(defaultPayment, that.defaultPayment) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeOfBusinessId, name, defaultPayment, notes);
    }

    @Override
    public String toString() {
        return "PlaceOfBusiness{" +
                "placeOfBusinessId=" + placeOfBusinessId +
                ", name='" + name + '\'' +
                ", defaultPayment='" + defaultPayment + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
