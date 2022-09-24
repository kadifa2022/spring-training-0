package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController2 {

    @RequestMapping("/mentor2")
    public String showTable(Model model){
        List<Mentor2> mentor2List= new ArrayList<>();
        mentor2List.add(new Mentor2("Lara","Smith", 23, Gender.MALE));
        mentor2List.add(new Mentor2("Tom","Hanks",43, Gender.MALE));
        mentor2List.add(new Mentor2("Mike", "Bryan", 23, Gender.MALE));
      model.addAttribute("mentors", mentor2List);
      return "mentor/mentor-list";


    }

}
