package com.spring.weatherapp.repository;

import com.spring.weatherapp.model.ZipCode;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import java.util.Collection;

@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCode, Long> {


    Collection<ZipCode> findByCod(String cod);



}
