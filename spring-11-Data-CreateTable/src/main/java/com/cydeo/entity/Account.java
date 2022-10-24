package com.cydeo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
@MappedSuperclass
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //postgres is assigning id for us
    private String id;
    private String Owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}
