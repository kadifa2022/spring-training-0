package com.cydeo.repository;

import com.cydeo.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketingRepository extends JpaRepository<Ticket, Long> {

    //---------------------DERIVED QUERIES--------------------------//

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountId(Long userId);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccountEmail(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinemaMovieName(String name);

    //Write a derived query to list all tickets between a range dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);

    //------------------------JPQL QUERIES----------------------------------//

    //Write a JPQL query that returns all tickets are bought from specific user
    @Query("SELECT t FROM Ticket t WHERE t.userAccount.id=?1")
    List<Ticket> fetchAllTicketsByUserAccount(@Param("userId") Long userId);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 and ?2")
    List<Ticket> fetchAllTicketsBetweenRangeOfDateTimes(@Param("dateTime1")LocalDateTime dateTime1, @Param("dateTime2") LocalDateTime dateTime2);


    //--------------------------------NATIVE QUERIES-------------------------------//


    //Write a native query to count the number if tickets a user bought
    @Query(value=" SELECT  count (*) FROM ticket WHERE user_accont_id=?1",nativeQuery = true)
    Integer countAllTicketByUserAccount(@Param("userId") Long userId);

    //Write a native query to count the number of tickets a user bought in a specific range dates
    @Query(value ="SELECT count(*) FROM ticket WHERE user_account_id=?1 AND date_time BETWEEN ?2 AND ?3" , nativeQuery = true)
    Integer countTicketByUserInDateRange(@Param("dayTime1") LocalDateTime dateTime1,
                                         @Param("dayTime2") LocalDateTime dateTime2,
                                         @Param("dayTime3") LocalDateTime dateTime3);
































}
