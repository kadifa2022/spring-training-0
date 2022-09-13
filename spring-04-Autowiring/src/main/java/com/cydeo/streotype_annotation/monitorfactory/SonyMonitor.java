package com.cydeo.streotype_annotation.monitorfactory;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SonyMonitor extends Monitor{


    public SonyMonitor() {
        super("25 inch", "Sony",25);
    }

    @Override
    public void drawPixelAt() {
        System.out.println("Drawing pixel with Sony");

    }
}
