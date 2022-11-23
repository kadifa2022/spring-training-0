package com.cydeo.repository;

import com.cydeo.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketingRepository extends JpaRepository<Ticket, Long> {

    //---------------------DERIVED QUERIES--------------------------//

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountId(Long userId);
}
