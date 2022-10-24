package com.cydeo.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name ="students")
public class Student {
    @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;
    @Column(name="studentFirstName")
    private String firstName;
    @Column(name="studentLastName")
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate birthday;
    @Column(columnDefinition = "DATE")
    private LocalDate birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDayTime;
}
