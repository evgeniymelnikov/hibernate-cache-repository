package com.github.evgeniymelnikov.hibernatecachetemplate.repository;

import com.github.evgeniymelnikov.hibernatecachetemplate.model.Author;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.QueryHint;
import java.util.UUID;

public interface AuthorRepository extends CrudRepository<Author, UUID> {

    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    Author findByName(String name);
}
