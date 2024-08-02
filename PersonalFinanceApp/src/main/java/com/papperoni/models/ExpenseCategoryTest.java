package com.papperoni.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseCategoryTest {

    @Test
    void testDefaultConstructor() {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        assertNotNull(expenseCategory);
    }

    @Test
    void testParameterizedConstructor() {
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness(); // Assume PlaceOfBusiness has a default constructor or use a mock
        ExpenseCategory expenseCategory = new ExpenseCategory(
                1L,
                "Groceries",
                placeOfBusiness,
                "Monthly grocery expenses"
        );

        assertEquals(1L, expenseCategory.getExpenseCategoryId());
        assertEquals("Groceries", expenseCategory.getCategoryName());
        assertEquals(placeOfBusiness, expenseCategory.getPlaceOfBusiness());
        assertEquals("Monthly grocery expenses", expenseCategory.getNotes());
    }

    @Test
    void testGettersAndSetters() {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness(); // Assume PlaceOfBusiness has a default constructor or use a mock

        expenseCategory.setExpenseCategoryId(2L);
        expenseCategory.setCategoryName("Utilities");
        expenseCategory.setPlaceOfBusiness(placeOfBusiness);
        expenseCategory.setNotes("Monthly utility bills");

        assertEquals(2L, expenseCategory.getExpenseCategoryId());
        assertEquals("Utilities", expenseCategory.getCategoryName());
        assertEquals(placeOfBusiness, expenseCategory.getPlaceOfBusiness());
        assertEquals("Monthly utility bills", expenseCategory.getNotes());
    }

    @Test
    void testToString() {
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness(); // Assume PlaceOfBusiness has a default constructor or use a mock
        ExpenseCategory expenseCategory = new ExpenseCategory(
                1L,
                "Groceries",
                placeOfBusiness,
                "Monthly grocery expenses"
        );

        String expected = "ExpenseCategory{" +
                "expenseCategoryId=1" +
                ", categoryName='Groceries'" +
                ", placeOfBusiness=" + placeOfBusiness +
                ", notes='Monthly grocery expenses'" +
                '}';

        assertEquals(expected, expenseCategory.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        PlaceOfBusiness placeOfBusiness1 = new PlaceOfBusiness(); // Assume PlaceOfBusiness has a default constructor or use a mock
        PlaceOfBusiness placeOfBusiness2 = new PlaceOfBusiness(); // Assume PlaceOfBusiness has a default constructor or use a mock

        ExpenseCategory expenseCategory1 = new ExpenseCategory(
                1L,
                "Groceries",
                placeOfBusiness1,
                "Monthly grocery expenses"
        );

        ExpenseCategory expenseCategory2 = new ExpenseCategory(
                1L,
                "Groceries",
                placeOfBusiness1,
                "Monthly grocery expenses"
        );

        ExpenseCategory expenseCategory3 = new ExpenseCategory(
                2L,
                "Utilities",
                placeOfBusiness2,
                "Monthly utility bills"
        );

        assertEquals(expenseCategory1, expenseCategory2);
        assertNotEquals(expenseCategory1, expenseCategory3);
        assertNotEquals(expenseCategory2, expenseCategory3);
        assertNotEquals(expenseCategory1, null);
        assertNotEquals(expenseCategory1, new Object());

        assertEquals(expenseCategory1.hashCode(), expenseCategory2.hashCode());
        assertNotEquals(expenseCategory1.hashCode(), expenseCategory3.hashCode());
    }
}
