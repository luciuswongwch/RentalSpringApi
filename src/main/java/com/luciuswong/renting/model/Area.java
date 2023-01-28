package com.luciuswong.renting.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Area {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int areaId;
    private String city;
    private String description;
    @OneToMany(mappedBy="area", fetch= FetchType.LAZY, cascade= CascadeType.PERSIST, targetEntity=Rental.class)
    private List<Rental> rentals;
}
