package com.luciuswong.renting.service;

import com.luciuswong.renting.model.Rental;
import com.luciuswong.renting.model.custom.RegionCount;
import com.luciuswong.renting.model.custom.PropertyTypeCount;
import com.luciuswong.renting.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    public Rental getRentalById(Integer id) {
        Optional<Rental> rental = rentalRepository.findById(id);
        return rental.orElse(null);
    }

    public List<Rental> getRentals(Integer numberOfRentals) {
        Integer qty = Math.toIntExact(rentalRepository.count());
        if (numberOfRentals >= qty) {
            return rentalRepository.findAll();
        } else {
            int pageIndex = (int) Math.floor(Math.random() * (qty / numberOfRentals));
            Page<Rental> rentalPage = rentalRepository.findAll(PageRequest.of(pageIndex, numberOfRentals));
            return rentalPage.getContent();
        }
    }

    public List<Rental> getRentalsByType(Rental.PropertyType propertyType) {
        return rentalRepository.findTop5ByPropertyType(propertyType);
    }

    public List<PropertyTypeCount> getTypeCount() {
        return rentalRepository.getCountByPropertyType();
    }

    public List<RegionCount> getRegionCount() {
        return rentalRepository.getCountByRegion();
    }

    public List<Rental> getTop3RentalsByLocation(String locationString) {
        return rentalRepository.findTop3ByRegion_Place(locationString);
    }
}
