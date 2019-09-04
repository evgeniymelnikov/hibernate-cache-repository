package com.github.evgeniymelnikov.hibernatecachetemplate.repository;

import com.github.evgeniymelnikov.hibernatecachetemplate.model.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PublisherRepository extends CrudRepository<Publisher, UUID> {
}
