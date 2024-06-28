package com.rcarrier.personalwebsite.portfolio.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// @Entity is a JPA annotation to make this object ready for storage in a JPA-based data store
// id, name and description are attributes of our Item domain object
@Entity
public class Weather {

    // @Id indicates primary key and automatically populated by JPA provider
    private @Id @GeneratedValue Long id;
    private String cityName;
    private String longitude;
    private String lattitude;
}
