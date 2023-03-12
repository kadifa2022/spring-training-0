package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    //Display all departments in the Furniture Department
    List<Department> findByDepartment(String department);

    //Display all Departments in the Health Division
    List<Department> findByDivision(String division);//all of them same thing
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //Display all departments with division name ends with 'isc'
    List<Department> findByDivisionEndsWith(String pattern);

    //Display top 3 departments with division name includes 'Hea' without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String pattern);
    @Query("SELECT d FROM Department d WHERE d.division IN ?1 ")
    List<Department> retrieveDepartmentDivision(List<String> division );












}
