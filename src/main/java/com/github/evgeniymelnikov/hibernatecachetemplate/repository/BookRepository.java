package com.github.evgeniymelnikov.hibernatecachetemplate.repository;

import com.github.evgeniymelnikov.hibernatecachetemplate.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookRepository extends CrudRepository<Book, UUID> {
}
