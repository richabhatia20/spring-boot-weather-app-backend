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
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collection;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/restcontroller")
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
        System.out.println("hii2");
        this.validateZip(cod);
        return this.zipCodeRepository.findByCod(cod);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/test",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> testMethod(){
        System.out.println("hii");
       // String location ="Boston";
        //return new ResponseEntity<User>(u,HttpStatus.OK);
       // return ResponseEntity.created(location).build();
        //return ResponseEntity.noContent().build();
        return new ResponseEntity<String>("HelloWorld!",HttpStatus.OK);
    }

    private void validateZip(String cod)
    {

       // this.zipCodeRepository.findByCod(cod).orElseThrow(() -> new ZipCodeNotFoundException(cod));
        System.out.print(zipCodeRepository.findByCod(cod));


        if(this.zipCodeRepository.findByCod(cod).size()>1)
        {

            System.out.println("found cod");
            System.out.println("size of list:" + this.zipCodeRepository.findByCod(cod).size());
        }
        else{
            System.out.println("not found");
            new ZipCodeNotFoundException(cod);
        }
    }

}
