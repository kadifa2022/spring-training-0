package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {//create class with controller

    //methods always String and needs to return view

    @RequestMapping("/home")     //parameter for what we are looking for
    public String getHomePage(){         //which en point will work www.@RequestMapping
        return  "home.html";        //view html

    }
    @RequestMapping("/ozzy")
    public String getHomePage2(){
        return "home.html";
    }

    @RequestMapping // nothing and /
    public String getHomePage3(){
        return "home.html";
    }



    @RequestMapping({"/apple","/orange"})
    public String getHomePage4(){
        return"home.html";
    }


}
