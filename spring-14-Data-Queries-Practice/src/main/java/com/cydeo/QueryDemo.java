package com.cydeo;


import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {
    private final DepartmentRepository departmentRepository;

    private final RegionRepository regionRepository;

    private final EmployeeRepository employeeRepository;

    public QueryDemo(DepartmentRepository departmentRepository, RegionRepository regionRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.regionRepository = regionRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------Regions--------------");

        System.out.println("findByCountry:" + regionRepository.findByCountry("Canada"));
        System.out.println("findByCountryContaining:" +regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByRegionDesc: " + regionRepository.findByCountryContainsOrderByRegionDesc("United"));
        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTopByCountry: " + regionRepository.findTopByCountry("United States"));
        System.out.println("indTopByCountryContainingOrderByRegion:" +regionRepository.findTopByCountryContainingOrderByRegion("United States"));


        System.out.println("------------------Departments--------------");

        System.out.println("findByDepartment:" + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision:" + departmentRepository.findByDivision("Health"));
        System.out.println("findByDivisionEndsWith:" + departmentRepository.findByDivisionEndsWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContains:" + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));


        System.out.println("------------------Employee--------------");
        System.out.println("findByFirstNameAndLastNameOrEmail:" + employeeRepository.findByFirstNameAndLastNameOrEmail("Berrie","Manueau","bmanueau0@dion.ne.jp"));
        System.out.println(employeeRepository.retrieveEmployeeDetail());
        System.out.println(employeeRepository.retrieveEmployeeSalary());




















    }
}
