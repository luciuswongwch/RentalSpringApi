package com.luciuswong.renting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Testimonial extends BaseEntity {
    @Id
    private int testimonialId;
}
