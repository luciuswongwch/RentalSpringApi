package com.luciuswong.renting.service;

import com.luciuswong.renting.model.Rental;
import com.luciuswong.renting.model.custom.PropertyType;
import com.luciuswong.renting.model.custom.PropertyTypeCount;
import com.luciuswong.renting.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

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

    public List<Rental> getRentalsByType(PropertyType propertyType) {
        return rentalRepository.findTop5ByPropertyType(propertyType);
    }

    public List<PropertyTypeCount> getTypeCount() {
        return rentalRepository.getCountByPropertyType();
    }
}
