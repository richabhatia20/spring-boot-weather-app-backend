package com.spring.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Coord {


    @OneToOne
    @PrimaryKeyJoinColumn
    private City cityValue;

    @Id
    @GeneratedValue
    private Long id;

    private String lon;
    private String lat;

    public Coord(){

        //jpa only
    }

    public City getCityValue() {
        return cityValue;
    }

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }
}
