package com.spring.weatherapp;

import com.spring.weatherapp.model.City;
import com.spring.weatherapp.model.ZipCode;
import com.spring.weatherapp.repository.CityRepository;
import com.spring.weatherapp.repository.ZipCodeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import java.util.Arrays;
import  org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.web.support.SpringBootServletInitializer;
//@SpringBootApplication

@Configuration @EnableAutoConfiguration
@ComponentScan(basePackages = {"com.spring.weatherapp.controller","com.spring.weatherapp.repository"})
@EnableJpaRepositories("com.spring.weatherapp.repository")

public class Application extends SpringBootServletInitializer {

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    //@Autowired
    @Bean
    CommandLineRunner init(ZipCodeRepository zipCodeRepository, CityRepository cityRepository){

        return (evt) -> Arrays.asList("boston,chicago".split(",")).forEach(
                a -> {
                    ZipCode zipCode = zipCodeRepository.save(new ZipCode( "02115","test","1"));
                    ZipCode zipCode2 = zipCodeRepository.save(new ZipCode( "410210","test2","2"));

                    cityRepository.save(new City(a, "US", "10000", zipCode));
                    cityRepository.save(new City(a, "US","20000", zipCode2));

                    System.out.println("printing from first zipcode: " + zipCode.getCod());
                    System.out.println("printing from second zipcode: " +zipCode2.getMessage());

                }

        );




    }
}

