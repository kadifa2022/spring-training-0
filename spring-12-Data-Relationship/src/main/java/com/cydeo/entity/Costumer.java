package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name="costumers")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String surName;
    private String userName;

   // @OneToMany(mappedBy = "customers")
   // private List<Payment> paymentList;


    //AllArgsConstructor without id
    public Costumer(String name, String address, String email, String surName, String userName) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.surName = surName;
        this.userName = userName;

    }
}
