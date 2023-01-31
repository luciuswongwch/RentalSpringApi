package com.luciuswong.renting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Region {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int regionId;
    private String place;
    private String description;
    @OneToMany(mappedBy="region", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity=Rental.class)
    @JsonManagedReference
    private List<Rental> rentals;
}
