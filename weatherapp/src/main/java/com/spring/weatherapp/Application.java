package com.spring.weatherapp;

import com.spring.weatherapp.model.City;
import com.spring.weatherapp.model.ZipCode;
import com.spring.weatherapp.repository.CityRepository;
import com.spring.weatherapp.repository.ZipCodeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import java.util.Arrays;

@SpringBootApplication
//@Configuration @EnableAutoConfiguration
@ComponentScan("com.spring.weatherapp")
public class Application {

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



                }

        );




    }
}

