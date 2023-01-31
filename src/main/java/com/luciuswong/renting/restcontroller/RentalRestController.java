package com.luciuswong.renting.restcontroller;

import com.luciuswong.renting.model.Rental;
import com.luciuswong.renting.model.custom.PropertyType;
import com.luciuswong.renting.model.custom.PropertyTypeCount;
import com.luciuswong.renting.repository.RentalRepository;
import com.luciuswong.renting.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RentalRestController {
    @Autowired
    private RentalService rentalService;

    @GetMapping("/rentals")
    public List<Rental> getRentals(@RequestParam(name="numberOfRentals") int numberOfRentals) {
        return rentalService.getRentals(numberOfRentals);
    }
    @GetMapping("/rentals/countByType")
    public List<PropertyTypeCount> getCountByType() {
        return rentalService.getTypeCount();
    }

    @RequestMapping("/rentals/type/{propertyType}")
    public List<Rental> getRentalsByType(@PathVariable(name="propertyType") PropertyType propertyType) {
        return rentalService.getRentalsByType(propertyType);
    }
}
