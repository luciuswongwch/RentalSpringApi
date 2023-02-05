package com.luciuswong.renting.repository;

import com.luciuswong.renting.model.Rental;
import com.luciuswong.renting.model.custom.RegionCount;
import com.luciuswong.renting.model.custom.PropertyTypeCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    @Query("SELECT new com.luciuswong.renting.model.custom.PropertyTypeCount(r.propertyType, COUNT(r.propertyType)) FROM Rental AS r GROUP BY r.propertyType")
    List<PropertyTypeCount> getCountByPropertyType();

    @Query("SELECT new com.luciuswong.renting.model.custom.RegionCount(r.region.place, COUNT(r.region)) FROM Rental AS r GROUP BY r.region.place")
    List<RegionCount> getCountByRegion();

    List<Rental> findTop5ByPropertyType(Rental.PropertyType propertyType);

    List<Rental> findTop3ByRegion_Place(String locationString);
}

