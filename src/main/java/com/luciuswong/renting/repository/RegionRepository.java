package com.luciuswong.renting.repository;

import com.luciuswong.renting.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    Region findByPlace(String place);
}
