package com.luciuswong.renting.model.custom;

import com.luciuswong.renting.model.Region;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegionCount {
    private String place;
    private Long count;
}
