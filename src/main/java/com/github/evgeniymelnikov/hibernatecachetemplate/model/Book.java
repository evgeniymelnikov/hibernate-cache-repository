package com.github.evgeniymelnikov.hibernatecachetemplate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "t_books", schema = "sc")
@NoArgsConstructor
@Getter
@Setter
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    private String name;

    @ManyToMany
    @JoinTable(
            name = "t_book_author",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name="publisher_id")
    private Publisher publisher;

    public Book(String name, List<Author> authors, Publisher publisher) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
    }
}
