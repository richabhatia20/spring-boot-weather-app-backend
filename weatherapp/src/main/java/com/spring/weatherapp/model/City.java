package com.spring.weatherapp.model;

import javax.persistence.*;

@Entity
public class City {


    @OneToOne
    @PrimaryKeyJoinColumn
    private ZipCode zipCode;

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String country;
    private String population;

    @OneToOne(mappedBy = "cityValue")
    private Coord coords;

    public City(){

        //jpa only
    }

    public City(String name, String country, String population, ZipCode zipCode)
    {
        this.name = name;
        this.country = country;
        this.population = population;
        this.zipCode = zipCode;

    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getPopulation() {
        return population;
    }

    public Coord getCoords() {
        return coords;
    }
}
