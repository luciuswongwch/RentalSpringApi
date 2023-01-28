package com.luciuswong.renting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Contact extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int contactId;
    @Email(message="Email address is invalid")
    private String email;
    @NotBlank(message="Title must not be blank")
    private String title;
    @Size(min=5, message="Message must be at least 5 characters")
    private String message;
}
