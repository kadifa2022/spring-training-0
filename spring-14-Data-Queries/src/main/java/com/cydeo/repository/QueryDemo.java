package com.cydeo.repository;

import org.springframework.boot.CommandLineRunner;

public class QueryDemo implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByRegionDesc:"+ regionRepository.findByCountryContainsOrderByRegionDesc("United"));

        System.out.println("Departments----");
    }
}
