package com.cydeo.streotype_annotation.motherboardfactory;

public class AsusMotherboard extends MotherBoard{
    public AsusMotherboard(){
        super("BJ-200", "Asus",4,6,"v2.44");
    }

    @Override
    public void loadProgram(String programName) {
        System.out.println("Program"+ programName + "is loading now...");

    }
}
