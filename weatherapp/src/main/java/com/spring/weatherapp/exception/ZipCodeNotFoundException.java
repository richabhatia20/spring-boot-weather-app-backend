package com.spring.weatherapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ZipCodeNotFoundException  extends  RuntimeException{

    public ZipCodeNotFoundException(String cod){

        super("Could not find zipcode " + cod);
    }


}
