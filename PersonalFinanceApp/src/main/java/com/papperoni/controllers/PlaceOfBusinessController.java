package com.papperoni.controllers;

import com.papperoni.models.PlaceOfBusiness;
import com.papperoni.services.PlaceOfBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places-of-business")
public class PlaceOfBusinessController {

    private final PlaceOfBusinessService placeOfBusinessService;

    @Autowired
    public PlaceOfBusinessController(PlaceOfBusinessService placeOfBusinessService) {
        this.placeOfBusinessService = placeOfBusinessService;
    }

    @GetMapping
    public List<PlaceOfBusiness> getAllPlacesOfBusiness() {
        return placeOfBusinessService.getAllPlacesOfBusiness();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceOfBusiness> getPlaceOfBusinessById(@PathVariable Long id) {
        PlaceOfBusiness placeOfBusiness = placeOfBusinessService.getPlaceOfBusinessById(id)
                .orElseThrow(() -> new RuntimeException("PlaceOfBusiness not found"));
        return ResponseEntity.ok(placeOfBusiness);
    }

    @PostMapping
    public PlaceOfBusiness createPlaceOfBusiness(@RequestBody PlaceOfBusiness placeOfBusiness) {
        return placeOfBusinessService.savePlaceOfBusiness(placeOfBusiness);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaceOfBusiness> updatePlaceOfBusiness(@PathVariable Long id, @RequestBody PlaceOfBusiness placeOfBusinessDetails) {
        PlaceOfBusiness updatedPlaceOfBusiness = placeOfBusinessService.updatePlaceOfBusiness(id, placeOfBusinessDetails);
        return ResponseEntity.ok(updatedPlaceOfBusiness);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaceOfBusiness(@PathVariable Long id) {
        placeOfBusinessService.deletePlaceOfBusiness(id);
        return ResponseEntity.noContent().build();
    }
}

