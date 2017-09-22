package com.spring.weatherapp.controller;


import com.spring.weatherapp.model.ZipCode;
import com.spring.weatherapp.repository.CityRepository;
import com.spring.weatherapp.repository.ZipCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.weatherapp.exception.ZipCodeNotFoundException;

import java.util.Collection;

@RestController
@RequestMapping("/{cod}")
public class ZipCodeRestController {

    private final ZipCodeRepository zipCodeRepository;
    private final CityRepository cityRepository;

    @Autowired
    ZipCodeRestController(ZipCodeRepository zipCodeRepository, CityRepository cityRepository){

        this.cityRepository = cityRepository;
        this.zipCodeRepository = zipCodeRepository;
    }

    @RequestMapping(method= RequestMethod.GET)
    Collection<ZipCode> getAllZipCodes(@PathVariable String cod){

        this.validateZip(cod);
        return this.zipCodeRepository.findByCod(cod);
    }


    private void validateZip(String cod)
    {

        this.zipCodeRepository.findByCod(cod).orElseThrow(
                () -> new ZipCodeNotFoundException(cod));

    }

}
