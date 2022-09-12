package com.cydeo.bean_annotation.monitorfactory;

public class SonyMonitor extends Monitor {


    public SonyMonitor(String model, String manufacturer, int size) {
        super(model, manufacturer, size);
    }

    @Override
    public void drawPixelAt() {

    }

    public void drawPixelAl(){
        System.out.println("Drawing pixel with Sony");
    }

}





