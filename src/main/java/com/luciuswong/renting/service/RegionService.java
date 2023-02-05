package com.luciuswong.renting.service;

import com.luciuswong.renting.model.Region;
import com.luciuswong.renting.model.Rental;
import com.luciuswong.renting.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getRegions(Integer numberOfAreas) {
        Integer qty = Math.toIntExact(regionRepository.count());
        if (numberOfAreas >= qty) {
            return regionRepository.findAll();
        } else {
            List<Integer> list = new Random().ints(0, qty)
                    .distinct()
                    .limit(numberOfAreas)
                    .boxed()
                    .collect(Collectors.toList());
            List<Region> res = new ArrayList<>();
            for (Integer idx : list) {
                Page<Region> areaPage = regionRepository.findAll(PageRequest.of(idx, 1));
                if (areaPage.hasContent()) {
                    res.add(areaPage.getContent().get(0));
                }
            }
            return res;
        }
    }

    public Region getRegionByPlace(String place) {
        return regionRepository.findByPlace(place);
    }
}
