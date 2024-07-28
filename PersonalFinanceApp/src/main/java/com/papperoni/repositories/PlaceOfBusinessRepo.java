package com.papperoni.repositories;

import com.papperoni.models.PlaceOfBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceOfBusinessRepo extends JpaRepository<PlaceOfBusiness, Long> {
}

