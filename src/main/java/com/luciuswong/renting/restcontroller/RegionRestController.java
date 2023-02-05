package com.luciuswong.renting.restcontroller;

import com.luciuswong.renting.model.Region;
import com.luciuswong.renting.repository.RegionRepository;
import com.luciuswong.renting.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegionRestController {
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private RegionService regionService;
    @GetMapping("/regions")
    public List<Region> getRegions(@RequestParam(name="numberOfRegions") int numberOfRegions) {
        return regionService.getRegions(numberOfRegions);
    }
    @GetMapping("/regions/{regionString}")
    public Region getRegionByPlace(@PathVariable(name="regionString") String regionString) {
        return regionService.getRegionByPlace(regionString);
    }
}
