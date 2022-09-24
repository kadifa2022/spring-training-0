package com.cydeo.model;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
@Data
@AllArgsConstructor
public class Mentor2 {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;


}
