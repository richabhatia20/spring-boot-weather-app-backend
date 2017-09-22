package com.spring.weatherapp.repository;

import com.spring.weatherapp.model.City;
import com.spring.weatherapp.model.ZipCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;


@Repository
//@Autowired

public interface CityRepository extends JpaRepository<City, Long> {


    Collection<City> findByZipCode(ZipCode zipCode);



}
