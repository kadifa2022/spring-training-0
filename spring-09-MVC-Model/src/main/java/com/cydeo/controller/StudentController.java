package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @RequestMapping("/welcome")//TYMELEAF tamplate
    public String homePage(Model model){//methode mode to take data to view
        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");
        return "student/welcome";

    }
}
