package com.papperoni.services.impl;

import com.papperoni.models.PlaceOfBusiness;
import com.papperoni.repositories.PlaceOfBusinessRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PlaceOfBusinessServiceImplTest {

    @Mock
    private PlaceOfBusinessRepo placeOfBusinessRepo;

    @InjectMocks
    private PlaceOfBusinessServiceImpl placeOfBusinessService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPlacesOfBusiness() {
        PlaceOfBusiness place1 = new PlaceOfBusiness(1L, "Place1", 100, "Notes1");
        PlaceOfBusiness place2 = new PlaceOfBusiness(2L, "Place2", 200, "Notes2");
        List<PlaceOfBusiness> places = Arrays.asList(place1, place2);

        when(placeOfBusinessRepo.findAll()).thenReturn(places);

        List<PlaceOfBusiness> result = placeOfBusinessService.getAllPlacesOfBusiness();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(place1, result.get(0));
        assertEquals(place2, result.get(1));

        verify(placeOfBusinessRepo, times(1)).findAll();
    }

    @Test
    void testGetPlaceOfBusinessById() {
        PlaceOfBusiness place = new PlaceOfBusiness(1L, "Place1", 100, "Notes1");

        when(placeOfBusinessRepo.findById(1L)).thenReturn(Optional.of(place));

        Optional<PlaceOfBusiness> result = placeOfBusinessService.getPlaceOfBusinessById(1L);

        assertTrue(result.isPresent());
        assertEquals(place, result.get());

        verify(placeOfBusinessRepo, times(1)).findById(1L);
    }

    @Test
    void testSavePlaceOfBusiness() {
        PlaceOfBusiness place = new PlaceOfBusiness(1L, "Place1", 100, "Notes1");

        when(placeOfBusinessRepo.save(any(PlaceOfBusiness.class))).thenReturn(place);

        PlaceOfBusiness result = placeOfBusinessService.savePlaceOfBusiness(place);

        assertNotNull(result);
        assertEquals(place, result);

        verify(placeOfBusinessRepo, times(1)).save(place);
    }

    @Test
    void testDeletePlaceOfBusiness() {
        doNothing().when(placeOfBusinessRepo).deleteById(1L);

        assertDoesNotThrow(() -> placeOfBusinessService.deletePlaceOfBusiness(1L));

        verify(placeOfBusinessRepo, times(1)).deleteById(1L);
    }

    @Test
    void testUpdatePlaceOfBusiness() {
        PlaceOfBusiness existingPlace = new PlaceOfBusiness(1L, "Place1", 100, "Notes1");
        PlaceOfBusiness updatedPlace = new PlaceOfBusiness(1L, "UpdatedPlace", 100, "UpdatedNotes");

        when(placeOfBusinessRepo.findById(1L)).thenReturn(Optional.of(existingPlace));
        when(placeOfBusinessRepo.save(any(PlaceOfBusiness.class))).thenReturn(updatedPlace);

        PlaceOfBusiness result = placeOfBusinessService.updatePlaceOfBusiness(1L, updatedPlace);

        assertNotNull(result);
        assertEquals(updatedPlace.getName(), result.getName());
        assertEquals(updatedPlace.getNotes(), result.getNotes());

        verify(placeOfBusinessRepo, times(1)).findById(1L);
        verify(placeOfBusinessRepo, times(1)).save(existingPlace);
    }
}
