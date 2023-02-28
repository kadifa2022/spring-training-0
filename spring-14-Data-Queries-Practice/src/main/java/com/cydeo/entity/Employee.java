package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Table(name= "employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;//can be bigDecimal
    @ManyToOne
    @JoinColumn(name = "department")//by default is department_id that's why we changed
    private Department department;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
