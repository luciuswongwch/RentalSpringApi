package com.luciuswong.renting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RentalDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int rentalDetailId;
    @Column(columnDefinition = "TEXT")
    @NotBlank(message="Description must not be blank")
    private String description;
    @NotBlank(message="Address must not be blank")
    private String address;
    @Size(min=0, message="Monthly rent must not be negative")
    private int monthlyRent;
    @Size(min=0, message="Square feet must not be negative")
    private int squareFeet;
    @Size(min=0, message="Number of bedrooms must not be negative")
    private int numberOfBedrooms;
    @Size(min=0, message="Number of baths must not be negative")
    private int numberOfBaths;
    private String exteriorMaterial;
    private String structureType;
    @Min(value=0, message="Garage size must not be negative")
    private int garageSize;
    private String builtYear;
    private String availableFrom;
}
