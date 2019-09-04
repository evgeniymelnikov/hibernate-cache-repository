package com.github.evgeniymelnikov.hibernatecachetemplate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "some_external_service_account", schema = "sc")
@NoArgsConstructor
@Getter
@Setter
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SomeSocialMediaAccount {

    @Id
    private Integer id;

    private String username;

    @OneToOne
    @MapsId
    @JoinColumn(name = "author_id")
    private Author author;

    public SomeSocialMediaAccount(String username, Author author) {
        this.username = username;
        this.author = author;
    }
}
