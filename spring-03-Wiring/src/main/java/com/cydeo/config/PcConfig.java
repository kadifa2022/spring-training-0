package com.cydeo.config;

import com.cydeo.casefactory.Case;
import com.cydeo.casefactory.DellCase;
import com.cydeo.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcConfig {


    @Bean
    public Dimensions dimensions(){
        return new Dimensions(50,10,10);}
    //tightly coupled// Wiring not good example IoC Needs to handle this
    @Bean
    public Case caseDell(Dimensions dimensions){ //wiring through methode parameter
        return new DellCase("220B","Dell", "240",dimensions);
    }



}
