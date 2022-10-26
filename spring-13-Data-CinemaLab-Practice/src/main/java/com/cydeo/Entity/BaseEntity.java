package com.cydeo.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass   //all the tables to have Id-we are not creating table from this clas- just using as parent
public class BaseEntity {
    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //postgres is creating for us primary key
    private Long id;
}
