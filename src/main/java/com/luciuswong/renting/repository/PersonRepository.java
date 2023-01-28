package com.luciuswong.renting.repository;

import com.luciuswong.renting.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person findByUsername(String username);
}
