package com.luciuswong.renting.service;

import com.luciuswong.renting.model.Region;
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
    private RegionRepository areaRepository;

    public List<Region> getRegions(Integer numberOfAreas) {
        Integer qty = Math.toIntExact(areaRepository.count());
        if (numberOfAreas >= qty) {
            return areaRepository.findAll();
        } else {
            List<Integer> list = new Random().ints(0, qty)
                    .distinct()
                    .limit(numberOfAreas)
                    .boxed()
                    .collect(Collectors.toList());
            List<Region> res = new ArrayList<>();
            for (Integer idx : list) {
                Page<Region> areaPage = areaRepository.findAll(PageRequest.of(idx, 1));
                if (areaPage.hasContent()) {
                    res.add(areaPage.getContent().get(0));
                }
            }
            return res;
        }
    }
}
