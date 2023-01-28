package com.luciuswong.renting.repository;

import com.luciuswong.renting.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
