package com.luciuswong.renting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luciuswong.renting.validation.FieldValueMatch;
import com.luciuswong.renting.validation.PasswordStrength;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@FieldValueMatch.List({
    @FieldValueMatch(field="email", fieldMatch="confirmEmail", message="Confirm email does not match"),
    @FieldValueMatch(field="password", fieldMatch="confirmPassword", message="Confirm password does not match")
})
public class Person extends BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int personId;
    @Size(min=5, message="Username must be at least 5 characters")
    private String username;
    @Email(message="Email address is invalid")
    private String email;
    @Email(message="Confirm email is invalid")
    @Transient
    @JsonIgnore
    private String confirmEmail;
    @Size(min=5, message="Password must be at least 5 characters")
    @PasswordStrength
    @JsonIgnore
    private String password;
    @Transient
    @JsonIgnore
    private String confirmPassword;
}
