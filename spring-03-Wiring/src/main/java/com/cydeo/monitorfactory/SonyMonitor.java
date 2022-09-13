package com.cydeo.monitorfactory;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class SonyMonitor extends Monitor{
    public SonyMonitor(String model, String manufacturer, int size) {
        super(model, manufacturer, size);
    }

    @Override
    public void drawPixelAt() {
        System.out.println("Drawing pixel with Sony");

    }
}
