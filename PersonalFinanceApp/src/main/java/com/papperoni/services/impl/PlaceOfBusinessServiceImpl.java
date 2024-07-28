package com.papperoni.services.impl;

import com.papperoni.models.PlaceOfBusiness;
import com.papperoni.repositories.PlaceOfBusinessRepo;
import com.papperoni.services.PlaceOfBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceOfBusinessServiceImpl implements PlaceOfBusinessService {

    private final PlaceOfBusinessRepo placeOfBusinessRepository;

    @Autowired
    public PlaceOfBusinessServiceImpl(PlaceOfBusinessRepo placeOfBusinessRepository) {
        this.placeOfBusinessRepository = placeOfBusinessRepository;
    }

    @Override
    public List<PlaceOfBusiness> getAllPlacesOfBusiness() {
        return placeOfBusinessRepository.findAll();
    }

    @Override
    public Optional<PlaceOfBusiness> getPlaceOfBusinessById(Long id) {
        return placeOfBusinessRepository.findById(id);
    }

    @Override
    public PlaceOfBusiness savePlaceOfBusiness(PlaceOfBusiness placeOfBusiness) {
        return placeOfBusinessRepository.save(placeOfBusiness);
    }

    @Override
    public void deletePlaceOfBusiness(Long id) {
        placeOfBusinessRepository.deleteById(id);
    }

    @Override
    public PlaceOfBusiness updatePlaceOfBusiness(Long id, PlaceOfBusiness placeOfBusinessDetails) {
        PlaceOfBusiness placeOfBusiness = placeOfBusinessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PlaceOfBusiness not found"));

        placeOfBusiness.setName(placeOfBusinessDetails.getName());
        placeOfBusiness.setNotes(placeOfBusinessDetails.getNotes());

        return placeOfBusinessRepository.save(placeOfBusiness);
    }
}
