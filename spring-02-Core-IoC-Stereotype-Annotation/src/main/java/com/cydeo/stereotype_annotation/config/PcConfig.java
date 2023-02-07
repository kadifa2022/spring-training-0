package com.cydeo.stereotype_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.cydeo.stereotype_annotation")//need to define where to look for configuration class
public class PcConfig {
}
