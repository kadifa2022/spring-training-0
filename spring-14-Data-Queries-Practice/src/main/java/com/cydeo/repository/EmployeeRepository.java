package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    //Display all employees with email addresss ""
    List<Employee> findByEmail(String email);

    //Display all employees with first name "" and last name "",
    //also show all employees with an email address ""

    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);//3 parameters

    //Display all employees that first name is not
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees starts with" Ka"
    List<Employee> findByLastNameStartingWith(String pattern);

    //Display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salary less than ""
    List<Employee> findBySalaryLessThan(Integer salary);

    //Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateIsBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries grater and equal to "" in order-salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees than is making less than
    List<Employee> findDistinctBySalaryIsLessThan(Integer salary);

    //Display all employees than do not have email address
    List<Employee> findByEmailIsNull();//if is null
   //STARTING JPQL


    @Query("SELECT e  FROM Employee e WHERE e.email ='bmanueau0@dion.ne.jp' ")
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee  e WHERE e.email= 'bmanueau0@dion.ne.jp' ")
    Integer retrieveEmployeeSalary();

    //Not equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ? 1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like / Contains/Startswiths/Endswiths

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //Less Than
    @Query("SELECT e FROM Employee e WHERE e.salary <?1")
    List<Employee> retrieveEmployeeSalaryLessThan (int salary);

    //Greater Than
    @Query("SELECT e.firstName FROM Employee e WHERE e.salary <?1")
    List<String> retrieveEmployeeSalaryLGreaterThan (int salary);

    //Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //BEFORE
    @Query("SELECT e FROM Employee e WHERE e.hireDate>?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);
    //null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> retrieveEmployeeEmailIsNull();

    // NOT null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //SORTING IN ASC ORDER
    @Query("SELECT e FROM Employee e ORDER BY e.salary ")
    List<Employee> retrieveEmployeeSalaryOrderAsc();


    //sorting in desc order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC ")
    List<Employee> retrieveEmployeeSalaryOrderDesc();


    //HOW TO WRITE NATIVE QUERY

    @Query(value="SELECT * FROM employee WHERE salary = ?1", nativeQuery = true) //positional
    List<Employee> retrieveEmployeeDetailsBySalary(int salary);

    //NAMED PARAMETER
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);

    //






























}
