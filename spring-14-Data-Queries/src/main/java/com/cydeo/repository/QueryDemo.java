package com.cydeo.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component//runner class
public class QueryDemo implements CommandLineRunner {


    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
    }


    @Override
    public void run(String... args) throws Exception {
                                    //using squel with methods that we created


        System.out.println("--------------------Region---------------------------");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("getByCountry: " + regionRepository.getByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
       System.out.println("findByCountryContainsOrderByRegionDesc:"+regionRepository.findByCountryContainsOrderByRegionDesc("United"));
        System.out.println("findByCountryContainsOrderByRegion:"+ regionRepository.findByCountryContainsOrderByRegion("United States"));
        System.out.println("findTopByCountry: " + regionRepository.findTopByCountry("United States"));
        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("United State"));


        System.out.println("---------------------Departments------------------------------");
        System.out.println("FindByDepartment:" + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision" + departmentRepository.findByDivision("Health"));
        System.out.println("findByDivisionEndsWith:" + departmentRepository.findByDivisionEndsWith("ics") );


      System.out.println("findDistinctTop3ByDivisionContains:"+ departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
    }


    }
