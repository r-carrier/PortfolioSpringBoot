package com.rcarrier.personalwebsite.portfolio.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// @Entity is a JPA annotation to make this object ready for storage in a JPA-based data store
// id, name and description are attributes of our Item domain object
@Entity
public class Item {

    // @Id indicates primary key and automatically populated by JPA provider
    private @Id @GeneratedValue Long id;
    private String name;
    private String description;

    // default constructor
    public Item () {}

    // This is a parameterized constructor because it accepts two parameters: name (a String) and description (also a String).
    // The purpose of this constructor is to allow the creation of an Item object where the name and description fields are initialized to the provided arguments.
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
