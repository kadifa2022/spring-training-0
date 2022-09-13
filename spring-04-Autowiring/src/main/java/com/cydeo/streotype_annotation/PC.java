package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.casefactory.Case;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import com.cydeo.streotype_annotation.motherboardfactory.MotherBoard;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PC {
    private Case theCase;
    private Monitor monitor;
    private MotherBoard motherboard;

   // public PC(Case theCase, Monitor monitor, MotherBoard motherboard) {
      //  this.theCase = theCase;
      // this.monitor = monitor;
       // this.motherboard = motherboard;
   // }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo(){
        //Fancy Graphics
        monitor.drawPixelAt();
    }

}
