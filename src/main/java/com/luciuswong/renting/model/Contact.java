package com.luciuswong.renting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Contact extends BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int contactId;
    @NotBlank(message="Name must not be blank")
    private String name;
    @Email(message="Email address is invalid")
    private String email;
    @NotBlank(message="Title must not be blank")
    private String title;
    @Size(min=5, message="Message must be at least 5 characters")
    private String message;
}
