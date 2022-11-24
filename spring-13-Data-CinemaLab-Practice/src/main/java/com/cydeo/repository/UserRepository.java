package com.cydeo.repository;

import com.cydeo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //----------------------DERIVED QUERIES---------------------//

    //Write a derived query to read a user with email
    Optional<User> findByEmail(String email);

    //Write a derived query to read a user with a username?
    Optional<User> findByUserName(String username);

    //Write a derived query to list all users that contain a specific name
    List<User> findAllByAccountNameContaining(String name);

    //Write a derived query to list all users that contain a specific name in  ignore case mode
    List<User> findAllByAccountNameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than specific age?
    List<User> findAllByAccountAgeGreaterThan(Integer age);

    //-----------------------JPQL QUERIES----------------------------//
    //Write a JPQL query than returns a user read by email?
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> fetchByEmailJPQL(@Param("email")String email);































}



