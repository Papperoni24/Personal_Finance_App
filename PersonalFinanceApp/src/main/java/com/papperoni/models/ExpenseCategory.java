package com.papperoni.models;

import jakarta.persistence.*;

import java.util.Objects;

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

    public ExpenseCategory() {
    }

    public ExpenseCategory(Long expenseCategoryId, String categoryName, PlaceOfBusiness placeOfBusiness, String notes) {
        this.expenseCategoryId = expenseCategoryId;
        this.categoryName = categoryName;
        this.placeOfBusiness = placeOfBusiness;
        this.notes = notes;
    }

    public Long getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(Long expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
        ExpenseCategory that = (ExpenseCategory) o;
        return Objects.equals(expenseCategoryId, that.expenseCategoryId) && Objects.equals(categoryName, that.categoryName) && Objects.equals(placeOfBusiness, that.placeOfBusiness) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseCategoryId, categoryName, placeOfBusiness, notes);
    }

    @Override
    public String toString() {
        return "ExpenseCategory{" +
                "expenseCategoryId=" + expenseCategoryId +
                ", categoryName='" + categoryName + '\'' +
                ", placeOfBusiness=" + placeOfBusiness +
                ", notes='" + notes + '\'' +
                '}';
    }
}
