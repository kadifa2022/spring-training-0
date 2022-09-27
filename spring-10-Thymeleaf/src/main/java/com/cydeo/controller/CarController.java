package com.cydeo.controller;

import com.cydeo.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/car")

public class CarController {
    @GetMapping("/register")
    public String register(Model model){
        List<String> carYear= Arrays.asList("2000-2006", "2007-2012", "2013-2017","2018-2022" );
        model.addAttribute("carYear",carYear);
        model.addAttribute("car", new Car());

        return "car/car-register";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("car") Car car){
        return "redirect:/mentor/register";
    }


}
