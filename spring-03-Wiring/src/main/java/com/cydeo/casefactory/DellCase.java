package com.cydeo.casefactory;

public class DellCase extends Case{
    public DellCase(String model, String manufacturer, Dimensions dimensions) {
        super(model, manufacturer, dimensions);
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Power button pressed");

    }
}
