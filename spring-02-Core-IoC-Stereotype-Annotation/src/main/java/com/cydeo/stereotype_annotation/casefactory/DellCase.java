package com.cydeo.stereotype_annotation.casefactory;

public class DellCase extends Case{
    public DellCase(String model, String manufacturer, String powerSupply) {
        super(model, manufacturer, powerSupply);
    }

    @Override
    public void pressPowerButton() {

    }
}
