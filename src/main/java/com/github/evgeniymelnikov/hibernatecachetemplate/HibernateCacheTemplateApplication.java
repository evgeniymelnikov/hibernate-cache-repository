package com.github.evgeniymelnikov.hibernatecachetemplate;

import com.github.evgeniymelnikov.hibernatecachetemplate.model.Author;
import com.github.evgeniymelnikov.hibernatecachetemplate.model.Book;
import com.github.evgeniymelnikov.hibernatecachetemplate.model.Publisher;
import com.github.evgeniymelnikov.hibernatecachetemplate.repository.AuthorRepository;
import com.github.evgeniymelnikov.hibernatecachetemplate.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HibernateCacheTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateCacheTemplateApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        return args -> {
            Publisher harperCollins = new Publisher("HarperCollins", null);
            harperCollins = publisherRepository.save(harperCollins);

            Book toKillAMockingbird = new Book("Убить пересмешника", null, harperCollins);
            Book goSetAWatchMan = new Book("Пойди, поставь сторожа", null, harperCollins);

            List<Book> harperLeeBooks = new ArrayList<>();
            harperLeeBooks.add(toKillAMockingbird);
            harperLeeBooks.add(goSetAWatchMan);

            Author harperLee = new Author("Харпер Ли", harperLeeBooks, null);
            List<Author> authors = new ArrayList<>();
            authors.add(harperLee);
            harperLeeBooks.forEach(book -> book.setAuthors(authors));
            authorRepository.save(harperLee);
        };
    }
}
