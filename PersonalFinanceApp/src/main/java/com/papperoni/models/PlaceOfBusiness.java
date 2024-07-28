package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "PlaceOfBusiness")
public class PlaceOfBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeOfBusinessId;

    @NotBlank
    private String name;

    private String notes;

    public PlaceOfBusiness() {
    }

    public PlaceOfBusiness(Long placeOfBusinessId, String name, String notes) {
        this.placeOfBusinessId = placeOfBusinessId;
        this.name = name;
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
        return Objects.equals(placeOfBusinessId, that.placeOfBusinessId) && Objects.equals(name, that.name) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeOfBusinessId, name, notes);
    }

    @Override
    public String toString() {
        return "PlaceOfBusiness{" +
                "placeOfBusinessId=" + placeOfBusinessId +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
