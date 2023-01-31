package com.luciuswong.renting.repository;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.luciuswong.renting.model.Rental;
import com.luciuswong.renting.model.custom.PropertyType;
import com.luciuswong.renting.model.custom.PropertyTypeCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    @Query("SELECT new com.luciuswong.renting.model.custom.PropertyTypeCount(r.propertyType, COUNT(r.propertyType)) FROM Rental AS r GROUP BY r.propertyType")
    List<PropertyTypeCount> getCountByPropertyType();

    Long countByPropertyType(PropertyType propertyType);

    List<Rental> findTop5ByPropertyType(PropertyType propertyType);
}

