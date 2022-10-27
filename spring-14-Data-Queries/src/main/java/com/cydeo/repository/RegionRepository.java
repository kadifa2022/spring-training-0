package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    //canada
    List<Region> findByCountry(String Country);
    List<Region>getByCountry(String country);

    //display all region with country name includes "united
    List<Region>findByCountryContaining(String  country);

    //Display all regions with country
    List<Region>findByCountryContainsOrderByRegionDesc(String country);



}
