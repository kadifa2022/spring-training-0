package com.cydeo.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component//runner class
public class QueryDemo implements CommandLineRunner {


    private final RegionRepository regionRepository;

    public QueryDemo(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @Override
    public void run(String... args) throws Exception {
                                    //using squel with methods that we created
        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
       /*
      System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByRegion:"+ regionRepository.findByCountryContainsOrderByRegion("United"));

        System.out.println("Departments----");

        System.out.println("findByDivision:"+departmentRepository.findDistinctByTop3ByDivisionContains("Hea"));
    }

        */
    }
}