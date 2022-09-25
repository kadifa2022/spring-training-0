package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    //localhost:8080/student/register
    @RequestMapping("register")
    public String register(Model model){
        model.addAttribute("students", DataGenerator.createStudent());
        return"student/register";
    }


    @RequestMapping("/drop")//localhost:8080/student/drop
    public String drop(){
        return "student/register";
    }



}
