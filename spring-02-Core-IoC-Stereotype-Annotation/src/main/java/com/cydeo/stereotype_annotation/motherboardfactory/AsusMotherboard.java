package com.cydeo.stereotype_annotation.motherboardfactory;

import jdk.swing.interop.SwingInterOpUtils;

public class AsusMotherboard extends Motherboard {


    public AsusMotherboard(String model, String manufacturer, int ramSlot, int cardSlot, String bios) {
        super(model, manufacturer, ramSlot, cardSlot, bios);
    }

    @Override
    public void loadProgram(String programName) {
        System.out.println("Program"+ programName+ "is now loading....");

    }
}
