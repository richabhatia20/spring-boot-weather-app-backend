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
@RequestMapping("/")
public class ZipCodeRestController {

    private final ZipCodeRepository zipCodeRepository;
    private final CityRepository cityRepository;

    @Autowired
    ZipCodeRestController(ZipCodeRepository zipCodeRepository, CityRepository cityRepository){

        this.cityRepository = cityRepository;
        this.zipCodeRepository = zipCodeRepository;
    }

    @RequestMapping(method= RequestMethod.GET, value ="/{cod}")
    Collection<ZipCode> getAllZipCodes(@PathVariable String cod){
        System.out.print("hii2");
        this.validateZip(cod);
        return this.zipCodeRepository.findByCod(cod);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/test")
    String testMethod(){
        System.out.print("hii");
        return "HelloWorld";
    }

    private void validateZip(String cod)
    {

       // this.zipCodeRepository.findByCod(cod).orElseThrow(() -> new ZipCodeNotFoundException(cod));
        System.out.print(zipCodeRepository.findByCod(cod));


        if(this.zipCodeRepository.findByCod(cod).size()>1)
        {

            System.out.println("found");
        }
        else{
            System.out.println("not found");
            new ZipCodeNotFoundException(cod);
        }
    }

}
