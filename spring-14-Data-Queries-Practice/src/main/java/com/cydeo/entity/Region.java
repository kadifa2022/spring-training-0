package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Table(name = "regions")
@Entity
@NoArgsConstructor
public class Region extends BaseEntity{
    private String region;
    private String country;
}
