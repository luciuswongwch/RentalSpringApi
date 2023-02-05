package com.luciuswong.renting.restcontroller;

import com.luciuswong.renting.model.Rental;
import com.luciuswong.renting.model.custom.RegionCount;
import com.luciuswong.renting.model.custom.PropertyTypeCount;
import com.luciuswong.renting.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RentalRestController {
    @Autowired
    private RentalService rentalService;

    @GetMapping("/rentals/{id}")
    public Rental getRentalById(@PathVariable(name="id") Integer id) {
        return rentalService.getRentalById(id);
    }

    @GetMapping("/rentals/countByType")
    public List<PropertyTypeCount> getCountByType() {
        return rentalService.getTypeCount();
    }

    @GetMapping("/rentals/countByRegion")
    public List<RegionCount> getCountByRegion() {
        return rentalService.getRegionCount();
    }

    @GetMapping("/rentals")
    public List<Rental> getRentals(@RequestParam(name="numberOfRentals") int numberOfRentals) {
        return rentalService.getRentals(numberOfRentals);
    }

    @RequestMapping("/rentals/type/{propertyType}")
    public List<Rental> getRentalsByType(@PathVariable(name="propertyType") Rental.PropertyType propertyType) {
        return rentalService.getRentalsByType(propertyType);
    }

    @RequestMapping("/rentals/location/top3/{location}")
    public List<Rental> getTop3RentalsByLocation(@PathVariable(name="location") String locationString) {
        return rentalService.getTop3RentalsByLocation(locationString);
    }
}
