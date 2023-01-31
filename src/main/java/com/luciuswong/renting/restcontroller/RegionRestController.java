package com.luciuswong.renting.restcontroller;

import com.luciuswong.renting.model.Region;
import com.luciuswong.renting.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegionRestController {
    @Autowired
    private RegionService regionService;
    @GetMapping("/areas")
    public List<Region> getRegions(@RequestParam(name="numberOfRegions") int numberOfRegions) {
        return regionService.getRegions(numberOfRegions);
    }
}
