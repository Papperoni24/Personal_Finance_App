package com.papperoni.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceOfBusinessTest {

    @Test
    void testDefaultConstructor() {
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness();
        assertNotNull(placeOfBusiness);
        assertNull(placeOfBusiness.getPlaceOfBusinessId());
        assertNull(placeOfBusiness.getName());
        assertEquals(0, placeOfBusiness.getDefaultPaymentID());
        assertNull(placeOfBusiness.getNotes());
    }

    @Test
    void testParameterizedConstructor() {
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness(1L, "PlaceName", 123, "Some notes");

        assertNotNull(placeOfBusiness);
        assertEquals(1L, placeOfBusiness.getPlaceOfBusinessId());
        assertEquals("PlaceName", placeOfBusiness.getName());
        assertEquals(123, placeOfBusiness.getDefaultPaymentID());
        assertEquals("Some notes", placeOfBusiness.getNotes());
    }

    @Test
    void testGettersAndSetters() {
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness();
        placeOfBusiness.setPlaceOfBusinessId(1L);
        placeOfBusiness.setName("PlaceName");
        placeOfBusiness.setDefaultPaymentID(123);
        placeOfBusiness.setNotes("Some notes");

        assertEquals(1L, placeOfBusiness.getPlaceOfBusinessId());
        assertEquals("PlaceName", placeOfBusiness.getName());
        assertEquals(123, placeOfBusiness.getDefaultPaymentID());
        assertEquals("Some notes", placeOfBusiness.getNotes());
    }

    @Test
    void testEquals() {
        PlaceOfBusiness place1 = new PlaceOfBusiness(1L, "PlaceName", 123, "Some notes");
        PlaceOfBusiness place2 = new PlaceOfBusiness(1L, "PlaceName", 123, "Some notes");
        PlaceOfBusiness place3 = new PlaceOfBusiness(2L, "AnotherPlace", 456, "Other notes");

        assertTrue(place1.equals(place2));
        assertFalse(place1.equals(place3));
        assertFalse(place1.equals(null));
        assertFalse(place1.equals("String"));
    }

    @Test
    void testHashCode() {
        PlaceOfBusiness place1 = new PlaceOfBusiness(1L, "PlaceName", 123, "Some notes");
        PlaceOfBusiness place2 = new PlaceOfBusiness(1L, "PlaceName", 123, "Some notes");

        assertEquals(place1.hashCode(), place2.hashCode());
    }

    @Test
    void testToString() {
        PlaceOfBusiness placeOfBusiness = new PlaceOfBusiness(1L, "PlaceName", 123, "Some notes");
        String expectedString = "PlaceOfBusiness{" +
                "placeOfBusinessId=" + 1L +
                ", name='PlaceName'" +
                ", defaultPaymentID=" + 123 +
                ", notes='Some notes'" +
                '}';

        assertEquals(expectedString, placeOfBusiness.toString());
    }
}
