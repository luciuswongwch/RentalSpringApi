package com.luciuswong.renting.model;

import com.luciuswong.renting.constants.RentingSpringConstants;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rental extends BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int rentalId;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, optional=false)
    @JoinColumn(name="area_id", referencedColumnName="areaId", nullable=false)
    private Area area;

    public enum PropertyType {
        Apartment, Condo, House, Townhouse
    }
}
