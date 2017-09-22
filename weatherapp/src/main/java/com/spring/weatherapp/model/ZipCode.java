package com.spring.weatherapp.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.ArrayList;

@Entity
public class ZipCode {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "zipCode")
    private City cities;

    public City getCities(){

        return cities;
    }

    public Long getId() {
        return id;
    }

    private String cod;
    private String message;
    private String cnt;


    public String getCod(){
        return cod;
    }

    public String getMessage(){

        return message;
    }

    public String getCnt(){
        return cnt;
    }

    //ArrayList of List pending

    public ZipCode(){
        //jpa only

    }

    public ZipCode(String cod, String message, String cnt ){
        this.cod =cod;
        this.message= message;
        this.cnt = cnt;

    }

    /*

    zipcode has
    -id
    -city
        -id
        -name
        -coord
            -lon
            -lat
       -country
       -population
    -cod
    -message
    -cnt
    -list
        -dt
        -temp
            -day
            -min
            -max
            -night
            -eve
            -morn
       -pressure
       -humidity
       -weather
            -id
            -main
            -description
            -icon
      -speed
      -deg
      -clouds + /snow/rain



     */

}
