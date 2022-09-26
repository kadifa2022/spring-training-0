package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    //localhost:8080/mentor/register
    @RequestMapping("register")
    public String register(Model model){
       model.addAttribute("mentors", DataGenerator.createStudent());

        return"mentors/register";
    }

    @RequestMapping("/drop")//localhost:8080/mentor/drop
    public String drop(){
        return "student/register";
    }

}
