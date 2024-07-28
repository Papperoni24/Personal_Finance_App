package com.papperoni.services;

import com.papperoni.models.PlaceOfBusiness;

import java.util.List;
import java.util.Optional;

public interface PlaceOfBusinessService {

    List<PlaceOfBusiness> getAllPlacesOfBusiness();

    Optional<PlaceOfBusiness> getPlaceOfBusinessById(Long id);

    PlaceOfBusiness savePlaceOfBusiness(PlaceOfBusiness placeOfBusiness);

    void deletePlaceOfBusiness(Long id);

    PlaceOfBusiness updatePlaceOfBusiness(Long id, PlaceOfBusiness placeOfBusinessDetails);
}
