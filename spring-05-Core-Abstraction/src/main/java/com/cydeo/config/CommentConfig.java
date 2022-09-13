package com.cydeo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages= "com.cydeo")
//@ComponentScan{basePackages={"com.cydeo.proxy", "com"}}
public class CommentConfig {
}
