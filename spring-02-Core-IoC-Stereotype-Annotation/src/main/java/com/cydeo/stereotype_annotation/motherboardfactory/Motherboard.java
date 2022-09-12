package com.cydeo.stereotype_annotation.motherboardfactory;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Motherboard {
    private String model;
    private String manufacturer;
    private int ramSlot;
    private int cardSlot;
    private String bios;

    public Motherboard(String model, String manufacturer, int ramSlot, int cardSlot, String bios) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.ramSlot = ramSlot;
        this.cardSlot = cardSlot;
        this.bios = bios;

    }

    public abstract void loadProgram(String programName);
}