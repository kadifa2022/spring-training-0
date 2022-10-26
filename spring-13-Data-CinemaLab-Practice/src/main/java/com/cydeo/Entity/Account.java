package com.cydeo.Entity;

import com.cydeo.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="account_details")
public class Account extends BaseEntity{

    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private Integer age;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private UserRole role;
   // spring is trying to put foreign key that's why we are mappingBY
    @OneToOne(mappedBy = "account")//sp
    private User user;


}
