package com.luciuswong.renting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.luciuswong.renting.constants.RentingSpringConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Rental extends BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int rentalId;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, optional=false)
    @JoinColumn(name="region_id", referencedColumnName="regionId", nullable=false)
    @JsonBackReference
    private Region region;

    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false, targetEntity=RentalDetail.class)
    @JoinColumn(name="rental_detail_id", referencedColumnName="rentalDetailId", nullable=false)
    @JsonManagedReference
    private RentalDetail rentalDetail;

    public enum PropertyType {
        Apartment, Condo, House, Townhouse, Villa
    }
}


