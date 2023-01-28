package com.luciuswong.renting.repository;

import com.luciuswong.renting.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
