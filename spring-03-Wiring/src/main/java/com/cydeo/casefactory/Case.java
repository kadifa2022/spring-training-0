package com.cydeo.casefactory;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Case {
    private String model;
    private String manufacturer;
    private Dimensions dimensions;

    public Case(String model, String manufacturer, Dimensions dimensions) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.dimensions = dimensions;
    }
    public abstract void pressPowerButton();
}
