package com.cydeo.repository;

import com.cydeo.Entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    //---------------------DERIVED QUERIES------------------------//

    //Write derived query to get cinema with specific name
    Optional<Cinema>findByName(String name);//optional because of throwing exception

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findFirst3bySponsoredNameContainingOrderBySponsoredName(String sponsoredName);
    //Write a derived query to list all cinemas in specific country

    List<Cinema> findAllByLocationCountry(String country);
    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findAllNameOrBySponsoredName(String name, String sponsoredName);

    //------------------------JPQL QUERIES-----------------------------//

    //Write a JPQL query to read a specific id

    @Query("SELECT  c.name FROM Cinema c WHERE  c.id=?1")
    String fetchById(@Param("id")Long id);


    //---------------------------NATIVE QUERIES------------------------//

    //Write a native query to read all cinema by location country
    @Query(value = "SELECT  * FROM cinema c JOIN locatio  l" +
            "ON l.id = c.location_id WHERE l.country=?1", nativeQuery = true)
    List<Cinema> retrieveAllBasedOnLocationCountry(@Param("locationCountry")String location);

}
