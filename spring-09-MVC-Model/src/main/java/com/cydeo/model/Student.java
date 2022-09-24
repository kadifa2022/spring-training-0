package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor// to create object
public class Student {
    private int id;
    private String firstName;
    private String lastName;
}
