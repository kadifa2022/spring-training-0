package com.cydeo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class MyController {

    @RequestMapping("/Kadifa")
    public String getMyPage(){
        return "my.htlm";

    }

}
