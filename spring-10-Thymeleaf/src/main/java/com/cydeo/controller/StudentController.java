package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/student")//in default get() methode with spring methode=RequestMethode.GET
@RequestMapping("/student")
public class StudentController {

    //localhost:8080/student/register
    @GetMapping("register")//
    public String register(Model model){
        model.addAttribute("students", DataGenerator.createStudent());
        return"student/register";
    }


    @PostMapping("/welcome")//localhost:8080/student/welcome?name=Ozzy
    public String welcome(){//@RequestParam  String name
   //
        return "student/welcome";
    }



}
